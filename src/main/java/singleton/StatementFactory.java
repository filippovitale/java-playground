package singleton;

public class StatementFactory extends Factory {

    private final static Factory uniqueInstance = new StatementFactory();

    public static Factory getUniqueIstance() {
        return uniqueInstance;
    }

    @Override
    public StatementType creteStatements(String statement) {
        throw new UnsupportedOperationException("TODO"); // TODO
    }
}
