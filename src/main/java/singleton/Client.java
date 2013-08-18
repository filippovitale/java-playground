package singleton;

public class Client {

    public static void main(String[] args) {
        Factory statementFactory = StatementFactory.getUniqueIstance();
        statementFactory.creteStatements("detailed");
    }

}
