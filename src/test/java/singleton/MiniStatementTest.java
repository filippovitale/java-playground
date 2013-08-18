package singleton;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MiniStatementTest {

    @Test
    public void testPrint() throws Exception {
        StatementType statement = new MiniStatement();
        assertThat(statement.print(), is("mini_statement"));
    }

}
