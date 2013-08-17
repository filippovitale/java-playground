package generics;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class A {

    public static void superCanAdd(List<? super B> lsb) {
//        lsb.add(new A()); // NO!
        lsb.add(new B()); // OK
        lsb.add(new C()); // OK
//        lsb.add(new Object()); // NO!
        lsb.add(null); // OK

//        A a = lsb.get(0); // NO!
//        B b = lsb.get(0); // NO!
//        C c = lsb.get(0); // NO!
        Object o = lsb.get(0);
    }

    public static void extentsCanGet(List<? extends B> leb) {
//        leb.add(new A()); // NO!
//        leb.add(new B()); // NO!
//        leb.add(new C()); // NO!
//        leb.add(new Object()); // NO!
        leb.add(null); // OK

        A a = leb.get(0); // OK
        B b = leb.get(0); // OK
//        C c = leb.get(0); // NO!
        Object o = leb.get(0); // OK
    }

    // http://www.ibm.com/developerworks/java/library/j-jtp04298/index.html
    public void reList(List<?> list) {
        Object e = list.get(0);
//        list.add(e); // NO! List<?> --> List<Object>
    }

    private <E> void reListWithCaptureHelper(List<E> list) {
        E e = list.get(0);
        list.add(e); // OK
    }

    public static <T> T identity(T arg) {
        return arg;
    }


    public static void main(String[] args) {

        superCanAdd(new ArrayList<A>()); // OK
        superCanAdd(new ArrayList<B>()); // OK
//        superCanAdd(new ArrayList<C>()); // NO!

//        extentsCanGet(new ArrayList<A>()); // NO!
        extentsCanGet(new ArrayList<B>()); // OK
        extentsCanGet(new ArrayList<C>()); // OK

        Integer i = 3;
        Integer identityI = identity(i);
        System.out.println(identityI);
        Number identityN = identity(i);
        System.out.println(identityN);
        Serializable identityS = identity(i);
        System.out.println(identityS);
        Object identityO = identity(i);
        System.out.println(identityO);

// http://www.javacodegeeks.com/2011/04/java-generics-quick-tutorial.html
        List<Apple> apples = new ArrayList<Apple>();
//        List<Fruit> fruits = apples; // NO!
        List<? extends Fruit> fruits = apples; // OK
//        fruits.add(new Strawberry()); // NO!

    }

}

class B extends A {
}

class C extends B {
}


class Fruit {
}

class Apple extends Fruit {
}

class Strawberry extends Fruit {
}

