import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree(12);

        IntStream.range(1,10).forEach(tree::insert);
        tree.print();
        tree.remove(4);
        tree.changePriority(5,1);
        tree.print();
    }
}
