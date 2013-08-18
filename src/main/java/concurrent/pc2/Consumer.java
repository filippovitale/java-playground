package concurrent.pc2;

public class Consumer implements Runnable {
    public static final int SLEEP_CONSUMER = 1400;
    Producer producer;

    Consumer(Producer producer) {
        this.producer = producer;
    }

    public void run() {
        while (true) {
            String message = producer.getMessage();
            System.out.println("Got message: \"" + message + "\"");
            try {
                Thread.sleep(SLEEP_CONSUMER);
            } catch (InterruptedException e) {
            }
        }
    }

    public static void main(String args[]) {
        Producer producer = new Producer();
        new Thread(producer).start();
        Consumer consumer = new Consumer(producer);
        new Thread(consumer).start();
    }
}

