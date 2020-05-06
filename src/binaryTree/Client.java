package binaryTree;

public class Client {
    public static void main(String[] args) {
        BinaryTree bt=new BinaryTree();
        System.out.println(bt);
        System.out.println(bt.getSize());
        System.out.println(bt.size2());
        System.out.println(bt.max());
        System.out.println(bt.search(100));
        System.out.println(bt.height());
        bt.preorder();
        System.out.println();
        bt.inorder();
        System.out.println();
        bt.postorder();
        System.out.println();
        bt.levelorder();
        bt.preorderI();
        bt.inorderI();
        System.out.println(bt.diameter());
        System.out.println(bt.diameterBtr());
        bt.levelOrderLW();
        bt.zigzag();
        System.out.println(bt.lca(40,50));
        bt.replaceWgSum();
        System.out.println(bt);
    }
}
