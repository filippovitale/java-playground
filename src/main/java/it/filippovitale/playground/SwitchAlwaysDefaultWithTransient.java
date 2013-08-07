package it.filippovitale.playground;

public class SwitchAlwaysDefaultWithTransient {

    static transient int aaa = 12;

    public static void main(String[] args) {

        switch (aaa) {
            case 12:
                System.out.println("12");
                break;
            default:
                System.out.println("default"); // Why it doesn't work?
        }

    }
}
