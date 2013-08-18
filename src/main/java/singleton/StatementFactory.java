package singleton;

public class StatementFactory extends Factory {

    private final static Factory uniqueInstance = new StatementFactory();

    public static Factory getUniqueInstance() {
        return uniqueInstance;
    }

    @Override
    public StatementType createStatements(String statementSelection) {
        if (statementSelection.equals("detailed")) {
            return new DetailedStatement();
        } else if (statementSelection.equals("mini")) {
            return new MiniStatement();
        } else {
            throw new IllegalArgumentException(String.format("Statement \"%s\" not recognized", statementSelection));
        }
    }
}
