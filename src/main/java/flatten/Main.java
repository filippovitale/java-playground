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

        System.out.println(tree);
        System.out.println("------------------------------------------------");
        System.out.println(new MyFlattenTree<Integer>().flattenInOrder(tree));
    }

}
