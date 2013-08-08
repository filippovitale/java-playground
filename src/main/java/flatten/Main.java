package flatten;

public class Main {

    public static void main(String[] args) {
        Tree<Integer> a = new Tree.Leaf<Integer>(10);
        Tree<Integer> b = new Tree.Node<Integer>(
                new Tree.Leaf<Integer>(50),
                new Tree.Leaf<Integer>(40),
                new Tree.Leaf<Integer>(90));
        Tree<Integer> c = new Tree.Leaf<Integer>(60);

        Tree<Integer> tree = new Tree.Node<Integer>(a, b, c);

        System.out.println(tree);
        System.out.println("------------------------------------------------");
        System.out.println(new MyFlattenTree<Integer>().flattenInOrder(tree));
    }

}
