package executor2;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import java.util.concurrent.*;
import java.util.List;
import java.util.ArrayList;

public class FutureCallable {

    private static final int nThreads = 3;
    public static ExecutorService e = Executors.newFixedThreadPool(nThreads);
    public static final int NUMBER_OF_TASKS = 10;

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        List<Future<String>> futures = new ArrayList<Future<String>>(NUMBER_OF_TASKS);

        System.out.println("Submitting the tasks");

        for (int i = 0; i < NUMBER_OF_TASKS; i++) {
            MyCallable myCallable = new MyCallable(i);
            Future<String> future = e.submit(myCallable);
            futures.add(future);
        }

        System.out.println("Waiting for the futures (in order)");

        for (Future<String> future : futures){
            System.out.println(future.get());
        }

        e.shutdown();
    }
}

class MyCallable implements Callable<String> {

    private int num;
    private long delay;

    public MyCallable(int n) {
        this.num = n;
        this.delay = n % 2 * 3000;
    }

    public String call() throws InterruptedException {
        String begin = (new SimpleDateFormat("ss")).format(new Date());
        Thread.sleep(delay);
        int sum = 0;
        for (int i = 1; i <= num; i++) {
            sum += i;
        }
        String end = (new SimpleDateFormat("ss")).format(new Date());
        return String.format("%s-%s i=%d sum=%d", begin, end, this.num, sum);
    }

}