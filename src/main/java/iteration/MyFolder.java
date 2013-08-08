package iteration;

import java.util.Queue;

public class MyFolder<T, U> implements Folder<T, U> {
    public U fold(U u, Queue<T> ts, Function2<T, U, U> function) {
        if (u == null || ts == null || function == null)
            throw new IllegalArgumentException();

        if (ts.isEmpty()) {
            return u;
        }

        T[] tsArray = (T[]) new Object[ts.size()];
        ts.toArray(tsArray);

        U acc = u;
        for (int i = 0; i < tsArray.length; i++) {
            acc = function.apply(tsArray[i], acc);
        }
        return acc;
    }
}
