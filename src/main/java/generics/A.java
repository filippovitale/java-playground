package generics;

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

    public static void main(String[] args) {

        superCanAdd(new ArrayList<A>()); // OK
        superCanAdd(new ArrayList<B>()); // OK
//        superCanAdd(new ArrayList<C>()); // NO!

//        extentsCanGet(new ArrayList<A>()); // NO!
        extentsCanGet(new ArrayList<B>()); // OK
        extentsCanGet(new ArrayList<C>()); // OK

    }

}

class B extends A {
}

class C extends B {
}
