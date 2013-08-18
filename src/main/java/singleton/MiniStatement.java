package singleton;

public class MiniStatement implements StatementType {
    @Override
    public String print() {
        System.out.println("Mini Statement - Created");
        return "mini_statement";
    }
}
