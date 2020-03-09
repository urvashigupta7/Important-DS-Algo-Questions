package linkedlist;

public class Client {
    public static void main(String[] args) throws Exception {
        LinkedList ll=new LinkedList();
        ll.addaAtBeg(24);
        ll.addLast(25);
        ll.addAt(1,26);
        System.out.println(ll);
        ll.reversePR();
        System.out.println(ll);
    }
}
