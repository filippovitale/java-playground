package executors;

import java.util.concurrent.*;

public class SingleThreadExecutor {

    public static void main(String args[]) {
        String result = null;
        try {
            result = serialTask();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.print(result);
    }

    public static String serialTask() throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        final Future<String> output1 = executor.submit(new Callable<String>() {
            @Override
            public String call() {
                // do Something
                return "a String from Task #1";

            }
        });

        final Future<String> output2 = executor.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                // do Something
                // Wait for the output of the above task using `Future.get()`.
                return output1.get() + ", a String from Task #2";
            }
        });

        Future<String> output3 = executor.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                // do Something
                return output2.get() + ", a String from Task #3";

            }
        });


        return "Output from 3rd task: " + output3.get();
    }

}
