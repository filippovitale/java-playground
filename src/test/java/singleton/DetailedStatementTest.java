package singleton;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class DetailedStatementTest {
    @Test
    public void testPrint() throws Exception {
        StatementType statement = new DetailedStatement();
        assertThat(statement.print(), is("detailed_statement"));
    }
}
