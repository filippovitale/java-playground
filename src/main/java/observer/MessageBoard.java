package observer;

import java.util.*;

public class MessageBoard extends Observable {
    private String message;

    public String getMessage() {
        return message;
    }

    public void changeMessage(String message) {
        this.message = message;
        setChanged();
        notifyObservers(getMessage());
    }

    public static void main(String[] args) throws InterruptedException {
        MessageBoard board = new MessageBoard();
        Student bob = new Student("bob");
        Student joe = new Student("joe");
        board.addObserver(bob);
        board.addObserver(joe);
        board.changeMessage("There is more work!");
        Thread.sleep(1000);
        board.changeMessage("Now even more");
    }
}

class Student implements Observer {
    private final String name;

    public Student(String name) {
        this.name = name;
    }

    public void update(Observable o, Object arg) {
        int numberOfOtherObservers = o.countObservers() - 1;
        System.out.printf("\"%s\" observed that: \"%s\" with other %d people%n", name, arg, numberOfOtherObservers);
    }
}
