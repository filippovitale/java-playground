package it.filippovitale.playground;

public class PlayWithTryCatch {

    public static void main(String args[]) {
        try {
//            int a = 2 / 0;
            System.exit(0);
        } catch (Exception e) {
            System.out.println("i am in catch block");
        } finally {
            System.out.println("finally");
        }
    }

}
