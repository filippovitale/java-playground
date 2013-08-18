package findarray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ReverseArray {

    public static Integer[] reverseArray(Integer[] inputArray) {

        if (inputArray == null) {
            throw new IllegalArgumentException("The input array can\'t be not null");
        }

        if (inputArray.length == 0) {
            return new Integer[0];
        }

        List<Integer> listToBeReversed = Arrays.asList(inputArray);
        Collections.reverse(listToBeReversed);
        Integer[] arrayReversed = listToBeReversed.toArray(new Integer[0]);
        return arrayReversed;
    }

    public static <T> List<T> reverseList(List<T> inputArray) {
        List<T> listToReverse = new ArrayList<T>(inputArray);
        Collections.reverse(listToReverse);
        return listToReverse;
    }
}
