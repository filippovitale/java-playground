package executor2;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

public class FutureCallable {

    private static final int nThreads = 3;
    public static ExecutorService e = Executors.newFixedThreadPool(nThreads);
    public static final int NUMBER_OF_TASKS = 10;

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        List<Future<String>> futures = ExecuteParallelOrdered();

        System.out.println("Waiting for the futures (in order)");
        for (Future<String> future : futures) {
            System.out.println(future.get());
        }

        CompletionService<String> completionService = ExecuteParallelNotInOrder();
        System.out.println("Waiting for the futures (*not* in order)");
        for (int i = 0; i < NUMBER_OF_TASKS; i++) {
            Future<String> future = completionService.take();
            System.out.println(future.get());
        }
    }

    private static List<Future<String>> ExecuteParallelOrdered() throws InterruptedException, ExecutionException {
        List<Future<String>> futures = new ArrayList<Future<String>>(NUMBER_OF_TASKS);

        System.out.println("Submitting the tasks");
        for (int i = 0; i < NUMBER_OF_TASKS; i++) {
            MyCallable myCallable = new MyCallable(i);
            Future<String> future = e.submit(myCallable);
            futures.add(future);
        }

        return futures;
    }

    private static CompletionService<String> ExecuteParallelNotInOrder() throws InterruptedException, ExecutionException {
        CompletionService<String> compService = new ExecutorCompletionService<String>(e);
        for (int i = 0; i < NUMBER_OF_TASKS; i++) {
            MyCallable myCallable = new MyCallable(i);
            compService.submit(myCallable);
        }

        return compService;

//        for (int idx = 0; idx < URLs.size(); ++idx) {
//            Future<PingResult> future = compService.take();
//            log(future.get());
//        }
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