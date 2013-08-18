package singleton;

public class DetailedStatement implements StatementType {
    @Override
    public String print() {
        System.out.println("Detailed Statement - Created");
        return "detailed_statement";
    }
}
