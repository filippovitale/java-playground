package findarray;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertThat;

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
        Integer[] integers = new Integer[]{1, 2, 3};
        Integer[] reversedArray = ReverseArray.reverseArray(integers);
        assertArrayEquals(new Integer[]{3, 2, 1}, reversedArray);
    }

    @Test
    public void shouldReturnAReversedList() {
        Integer[] integers = new Integer[]{1, 2, 3};
        List<Integer> integerList = Arrays.asList(integers);

        List<Integer> reversedList = ReverseArray.reverseList(integerList);
//        assertSame(Arrays.asList(new Integer[]{3, 2, 1}), reversedList); // NO!
        assertThat(reversedList, is(Arrays.asList(new Integer[]{3, 2, 1})));
    }
}
