package generics;

public class A<E> {

    void doSomething(E e) {
    }

    public static void main(String[] args) {
    }

}

class B<D> extends A<D> {

}

class C<E> extends B<E> {

}