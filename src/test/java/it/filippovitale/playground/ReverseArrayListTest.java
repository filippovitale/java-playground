package it.filippovitale.playground;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;

public class ReverseArrayListTest {

    @Test
    public void testReverseEven() throws Exception {
        int[] i = {1, 2, 3, 4, 5, 6};
        ReverseArrayList.reverse(i);
        assertArrayEquals(new int[]{6, 5, 4, 3, 2, 1}, i);
    }

    @Test
    public void testReverseOdd() throws Exception {
        int[] i = {1, 2, 3, 4, 5};
        ReverseArrayList.reverse(i);
        assertArrayEquals(new int[]{5, 4, 3, 2, 1}, i);
    }

    @Test
    public void testReverseArrayList() throws Exception {
        List<Integer> forwardList = new ArrayList<Integer>();
        forwardList.add(1);
        forwardList.add(2);
        forwardList.add(3);
        forwardList.add(4);

        Integer[] bbb = forwardList.toArray(new Integer[forwardList.size()]);
        List<Integer> reverseList = new ArrayList<Integer>(forwardList.size());
        for (int i = bbb.length - 1; i >= 0; i--) {
            reverseList.add(bbb[i]);
        }

        ReverseArrayList.reverseArrays(forwardList);
        assertEquals(reverseList, forwardList);
    }
}
