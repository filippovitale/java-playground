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

        if (isLeaf) {
            result.add(LeafOrNode.ifLeft(getLeafFunction));
        } else {
            inOrderTraverse(LeafOrNode.ifRight(getNodeFunction).left(), result);
            inOrderTraverse(LeafOrNode.ifRight(getNodeFunction).middle(), result);
            inOrderTraverse(LeafOrNode.ifRight(getNodeFunction).right(), result);
        }
    }

    private Function<T, T> getLeafFunction = new Function<T, T>() {
        public T apply(T leaf) {
            return leaf;
        }
    };
    private Function<Triple<Tree<T>>, Triple<Tree<T>>> getNodeFunction = new Function<Triple<Tree<T>>, Triple<Tree<T>>>() {
        public Triple<Tree<T>> apply(Triple<Tree<T>> node) {
            return node;
        }
    };

}
