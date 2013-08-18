package singleton;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class StatementFactoryTest {

    private static final Factory statementFactory = StatementFactory.getUniqueInstance();

    @Test
    public void shouldInstancebeNotNullAndUnique() throws Exception {
        assertNotNull(statementFactory);

        Factory sameInstance = StatementFactory.getUniqueInstance();
        assertEquals(statementFactory, sameInstance);
    }

    @Test
    public void shouldCreateStatements() throws Exception {
        StatementType detailedStatement = statementFactory.createStatements("detailed");
        assertEquals("detailed_statement", detailedStatement.print());

        StatementType miniStatement = statementFactory.createStatements("mini");
        assertEquals("mini_statement", miniStatement.print());
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionForUnknownStatement() throws Exception {
        statementFactory.createStatements("unknown");
    }

}
