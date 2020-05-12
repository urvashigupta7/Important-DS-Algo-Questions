package bst;

public class Client {
    public static void main(String[] args) {
        int []in={12,25,37,50,62,75,87};
        BinarySearchTree b=new BinarySearchTree(in);
        System.out.println(b);
        System.out.println(b.max());
        b.add(30);
        System.out.println(b);
        b.remove(30);
        System.out.println(b);

    }
}
