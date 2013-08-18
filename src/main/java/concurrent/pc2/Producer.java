package concurrent.pc2;

import java.util.ArrayList;
import java.util.List;

public class Producer implements Runnable {
    static final int MAXQUEUE = 5;
    private List messages = new ArrayList();

    public void run() {
        while (true) {
            putMessage();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
        }
    }

    // called by Producer internally
    private synchronized void putMessage() {
        while (messages.size() >= MAXQUEUE)
            try {
                wait();
            } catch (InterruptedException e) {
            }
        messages.add(new java.util.Date().toString());
        notify();
    }

    // called by Consumer externally
    public synchronized String getMessage() {
        while (messages.size() == 0)
            try {
                notify();
                wait();
            } catch (InterruptedException e) {
            }
        String message = messages.remove(0) + "messages.size()=" + messages.size();
        notify();
        return message;
    }
}
