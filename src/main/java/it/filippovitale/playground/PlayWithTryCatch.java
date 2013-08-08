package it.filippovitale.playground;

public class PlayWithTryCatch {

    public static boolean tof() {
        try {
            return true;
        } catch (Exception e) {

        } finally {
            return false;
        }

    }

    public static void main(String args[]) {
        if (tof()) {
            System.out.println("tof true");
        } else {
            System.out.println("tof false");
        }
        try {
//            int a = 2 / 0;
            System.exit(0);
        } catch (Exception e) {
//            System.out.println("i am in catch block");
        } finally {
            System.exit(1);
//            System.out.println("finally");
        }
    }

}
