package concurrent.queue1;


import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;


public class ConcurrentLinkedQueueTest {

    ConcurrentLinkedQueue<String> clq = new ConcurrentLinkedQueue<String>();

    class AddThread implements Runnable {

        @Override
        public void run() {
            clq.add("A");
            clq.offer("B");
            clq.poll();

            Iterator<String> itr = clq.iterator();
            while (itr.hasNext()) {
                System.out.println(itr.next());
            }
        }
    }

    public static void main(String... args) {
        new Thread(new ConcurrentLinkedQueueTest().new AddThread()).start();
        new Thread(new ConcurrentLinkedQueueTest().new AddThread()).start();
    }
}