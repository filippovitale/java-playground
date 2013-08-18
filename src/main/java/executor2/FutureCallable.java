package executor2;

import java.util.concurrent.*;
import java.util.List;
import java.util.ArrayList;

public class FutureCallable {

    private static final int nThreads = 3;
//    public static ExecutorService e = Executors.newFixedThreadPool(nThreads);
    public static ExecutorService e = Executors.newSingleThreadExecutor();

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        List<String> outputs = new ArrayList<String>();

        for (int i = 0; i < 10; i++) {
            MyCallable myCallable = new MyCallable();  // TODO move into constructor
            myCallable.setNum(i);

            int delay = i % 2 * 800;
            myCallable.setDelay(delay);

            // On the executor you can use the method submit to "submit" (instead of .execute(..)) a Callable and to get a future.
            // To retrieve the result of the future use the get()
            Future<String> future = e.submit(myCallable);
            outputs.add(future.get());
        }

        System.out.println("Waiting for the futures (in order)");

        for (String o : outputs) {
            System.out.println(o);
        }

        e.shutdown();
    }
}

class MyCallable implements Callable<String> {

    private int num;
    private long delay;

    public void setNum(int n) {
        this.num = n;
    }

    public void setDelay(int delay) {
        this.delay = delay;
    }

    public String call() throws InterruptedException {
        Thread.sleep(delay);
        int sum = 0;
        for (int i = 1; i <= num; i++) {
            sum += i;
        }
        return "Sum of " + this.num + " numbers is: " + sum;
    }

}