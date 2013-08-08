package flatten;

import java.util.LinkedList;
import java.util.List;

public class MyFlattenTree<T> implements FlattenTree<T> {

    public List<T> flattenInOrder(Tree<T> tree) {
        if (tree == null) {
            throw new IllegalArgumentException();
        }

        List<T> result = new LinkedList<T>();
        inOrderTraverse(tree, result);
        return result;
    }

    private void inOrderTraverse(Tree<T> tree, List<T> result) {
        Either<T, Triple<Tree<T>>> LeafOrNode = tree.get();
        boolean isLeaf = LeafOrNode.isLeft();

        Function<T,T> getLeaf = new MyFunction<T, T>();

        if (isLeaf) {
            result.add(LeafOrNode.ifLeft(getLeaf));
        } else {
            inOrderTraverse(LeafOrNode.ifRight(new MyFunction<Triple<Tree<T>>, Triple<Tree<T>>>()).left(), result);
            inOrderTraverse(LeafOrNode.ifRight(new MyFunction<Triple<Tree<T>>, Triple<Tree<T>>>()).middle(), result);
            inOrderTraverse(LeafOrNode.ifRight(new MyFunction<Triple<Tree<T>>, Triple<Tree<T>>>()).right(), result);
        }

    }

}

class MyFunction<P,R> implements Function<P,R> {
    public R apply(P p) {
        return (R) p;
    }
}