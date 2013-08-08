package flatten;

public class Main {

    public static void main(String[] args) {
        Tree<Integer> a = new Tree.Leaf<Integer>(1);
        Tree<Integer> b = new Tree.Node<Integer>(
                new Tree.Leaf<Integer>(5),
                new Tree.Leaf<Integer>(4),
                new Tree.Leaf<Integer>(9));
        Tree<Integer> c = new Tree.Leaf<Integer>(6);

        Tree<Integer> tree = new Tree.Node<Integer>(a, b, c);

        System.out.println(new MyFlattenTree<Integer>().flattenInOrder(tree));

        System.out.println("------------------------------------------------");

        tree = new Tree.Node<Integer>(
                new Tree.Leaf<Integer>(1),
                new Tree.Node<Integer>(
                        new Tree.Node<Integer>(
                                new Tree.Leaf<Integer>(2),
                                new Tree.Leaf<Integer>(3),
                                new Tree.Leaf<Integer>(4)),
                        new Tree.Leaf<Integer>(5),
                        new Tree.Leaf<Integer>(6)),
                new Tree.Leaf<Integer>(7));

        System.out.println(new MyFlattenTree<Integer>().flattenInOrder(tree));

    }

}
