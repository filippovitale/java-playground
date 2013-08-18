package concurrent.pc3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Consumer consumer = new ConsumerImpl(10);

        BufferedReader br =
                new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream(
                                        new File(args[0]))));

        String line;
        while ((line = br.readLine()) != null) {
            System.out.println("Producer producing: " + line);
            consumer.consume(new PrintJob(line));
        }

        consumer.finishConsumption();
    }
}

class ItemProcessor implements Runnable {
    private BlockingQueue<Item> jobQueue;

    private volatile boolean keepProcessing;

    public ItemProcessor(BlockingQueue<Item> queue) {
        jobQueue = queue;
        keepProcessing = true;
    }

    public void run() {
        while (keepProcessing || !jobQueue.isEmpty()) {
            try {
                Item j = jobQueue.poll(10, TimeUnit.SECONDS);

                if (j != null) {
                    j.process();
                }
            } catch (InterruptedException ie) {
                Thread.currentThread().interrupt();
                return;
            }
        }
    }

    public void cancelExecution() {
        this.keepProcessing = false;
    }
}

class PrintJob implements Item {
    private String line;

    public PrintJob(String s) {
        line = s;
    }

    public void process() {
        System.out.println(
                Thread.currentThread().getName() +
                        " consuming :" + line);
    }
}

class ConsumerImpl implements Consumer {
    private BlockingQueue<Item> itemQueue = new LinkedBlockingQueue<Item>();
    private ExecutorService executorService = Executors.newCachedThreadPool();
    private List<ItemProcessor> jobList = new LinkedList<ItemProcessor>();

    private volatile boolean shutdownCalled = false;

    public ConsumerImpl(int poolSize) {
        for (int i = 0; i < poolSize; i++) {
            ItemProcessor jobThread =
                    new ItemProcessor(itemQueue);

            jobList.add(jobThread);
            executorService.submit(jobThread);
        }
    }

    public boolean consume(Item j) {
        if (!shutdownCalled) {
            try {
                itemQueue.put(j);
            } catch (InterruptedException ie) {
                Thread.currentThread().interrupt();
                return false;
            }
            return true;
        } else {
            return false;
        }
    }

    public void finishConsumption() {
        shutdownCalled = true;

        for (ItemProcessor j : jobList) {
            j.cancelExecution();
        }

        executorService.shutdown();
    }
}

interface Item {
    public void process();
}

interface Consumer {
    public boolean consume(Item j);

    public void finishConsumption();
}