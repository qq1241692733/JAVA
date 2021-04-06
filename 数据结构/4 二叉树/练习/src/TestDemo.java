import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-01-2021/1/26
 * Time: 11:21
 */
public class TestDemo {

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        Node root = binaryTree.cre();
        binaryTree.preOrderTraversal(root);
        binaryTree.preOrderTraversal1(root);
        System.out.println();
        binaryTree.inOrderTraversal(root);
        System.out.println();
        binaryTree.postOrderTraversal(root);
        System.out.println();
        binaryTree.levelOrderTraversal(root);
        binaryTree.find(root,'I');
        System.out.println();
        System.out.println(binaryTree.isCompleteTree(root));
    }

    
}
