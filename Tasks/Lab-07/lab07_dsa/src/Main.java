import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        BST bst = new BST();

        IntStream.range(1,10).forEach(bst::insert);
        IntStream.range(-10,1).forEach(bst::insert);
        bst.preorder();
        bst.inorder();
        bst.postorder();
        System.out.println(bst.height());
    }
}
