package binaryTree;

public class Client {
    public static void main(String[] args) {
        BinaryTree bt=new BinaryTree();
        System.out.println(bt);
        System.out.println(bt.getSize());
        System.out.println(bt.size2());
        System.out.println(bt.max());
        System.out.println(bt.search(100));

    }
}
