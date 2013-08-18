package mergesort;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class ParallelMergeSortTest {

    @Test
    public void testSort() throws Exception {
        Comparable[] a1 = new String[]{"asdff", "sfsdf", "assss", "asfsfd","asdff", "sfsdf", "assss", "asfsfd","asdff", "sfsdf", "assss", "asfsfd","asdff", "sfsdf", "assss", "asfsfd","asdff", "sfsdf", "assss", "asfsfd",};
        ParallelMergeSort.sort(a1);
        assertNotNull(a1);
    }
}
