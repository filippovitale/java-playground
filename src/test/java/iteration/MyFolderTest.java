package iteration;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.LinkedList;
import java.util.Queue;

import static org.junit.Assert.assertEquals;


public class MyFolderTest {

    private final String a = "!";
    private Queue<String> b;
    private Function2 c = new Function2() {
        public Object apply(Object a, Object b) {
            return String.format("%s %s", a, b);
        }
    };

    @Before
    public void setUp() {
        b = new LinkedList<String>();
        b.add("A");
        b.add("B");
        b.add("C");
        b.add("D");
    }

    @Rule
    public ExpectedException exception = ExpectedException.none();


    @Test
    public void testFoldRecursive() throws Exception {
        assertEquals("D C B A !", new MyFolder(true).fold(a, b, c));
    }

    @Test
    public void testFoldIterable() throws Exception {
        assertEquals("D C B A !", new MyFolder(false).fold(a, b, c));
    }

    @Test
    public void testWrongInput() throws Exception {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("All the input parameters must be not null");
        assertEquals("D C B A !", new MyFolder(false).fold(null, b, c));
    }
}
