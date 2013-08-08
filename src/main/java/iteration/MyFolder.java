package iteration;

import java.util.Iterator;
import java.util.Queue;

public class MyFolder<T, U> implements Folder<T, U> {
    public U fold(U u, Queue<T> ts, Function2<T, U, U> function) {
        if (u == null || ts == null || function == null)
            throw new IllegalArgumentException();

        if (ts.isEmpty()) {
            return u;
        }

        if (true)
            return fold(function.apply(ts.poll(), u), ts, function);

        Iterator<T> tsIterator = ts.iterator();

        U acc = u;
        while (tsIterator.hasNext()) {
            acc = function.apply(tsIterator.next(), acc);
        }
        return acc;
    }
}
