package it.filippovitale.playground;

abstract class PlayWithAbstractClass {
    public void myMethod() {
        System.out.print("Abstract");
    }
}

class poly extends PlayWithAbstractClass {
    public static void main(String a[]) {
        PlayWithAbstractClass m = new PlayWithAbstractClass() {
        };
        m.myMethod();
    }
}
