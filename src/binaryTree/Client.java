package binaryTree;
//    10 true 20 true 40 false false true 50 false false true 30 true 60 false false true 70 false false

public class Client {
    public static void main(String[] args) {
        BinaryTree bt=new BinaryTree();
        int []in={40,20,50,10,60,30,70};
        int []pre={10,20,40,50,30,60,70};
        int []post={40,50,20,60,70,30,10};
        //for full binary tree
        BinaryTree bt2=new BinaryTree(pre,post);
        System.out.println(bt2);
//        BinaryTree bt2=new BinaryTree(pre,in);
//        System.out.println(bt2);
//        System.out.println(bt);
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
//        bt.replaceWgSum();
//        System.out.println(bt);
        System.out.println(bt.maxsumpath());
    }
}
