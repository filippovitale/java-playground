package singleton;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Client {

    public static void main(String[] args) {
        Factory statementFactory = StatementFactory.getUniqueInstance();
        statementFactory.createStatements("detailed");

        System.out.println("Enter your selection:");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String selection = null;
        try {
            selection = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Factory factory = StatementFactory.getUniqueInstance();
        StatementType objStmtType = factory.createStatements(selection);
        System.out.println(objStmtType.print());
    }

}
