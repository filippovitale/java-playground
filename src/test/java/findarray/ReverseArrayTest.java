package findarray;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class ReverseArrayTest {

    @Test(expected = IllegalArgumentException.class)
    public void shouldNullArrayThrowException() throws Exception {
        ReverseArray.reverseArray(null);
    }

    @Test
    public void shouldEmptyAReverseArrayOfAnEmptyArray() throws Exception {
        Integer[] emptyArray = new Integer[0];
        Integer[] reversedArray = ReverseArray.reverseArray(emptyArray);
        assertArrayEquals(new Integer[0], reversedArray);
    }

    @Test
    public void shouldReturnAReversedArray() {
        Integer[] emptyArray = new Integer[]{1, 2, 3};
        Integer[] reversedArray = ReverseArray.reverseArray(emptyArray);
        assertArrayEquals(new Integer[]{3, 2, 1}, reversedArray);
    }
}
