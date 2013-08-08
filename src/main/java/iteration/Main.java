package iteration;

import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {
        String a = "!!!";
        Queue<String> b = new LinkedList<String>();
        b.add("AAA");
        b.add("BBB");
        b.add("CCC");
        b.add("DDD");

        Function2 c = new Function2() {
            public Object apply(Object a, Object b) {
                return String.format("%s %s", a, b);
            }
        };
        System.out.println(new MyFolder().fold(a, b, c));
        System.out.println("expected:");
        System.out.println("DDD CCC BBB AAA !!!\n");
    }

}
