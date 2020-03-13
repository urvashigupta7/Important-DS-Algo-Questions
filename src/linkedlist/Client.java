package linkedlist;

public class Client {
    public static void main(String[] args) throws Exception {
        LinkedList ll=new LinkedList();
        ll.addaAtBeg(24);
        ll.addLast(25);
        ll.addAt(1,26);
        System.out.println(ll);
        ll.reverseDR();
        System.out.println(ll);
        LinkedList ll4=new LinkedList();
        ll4.addLast(10);
        ll4.addLast(1);
        ll4.addLast(6);
        ll4.addLast(5);
        ll4.addLast(7);
        ll4.addLast(8);
        ll4.addLast(3);
//        System.out.println(ll4.getMidData());
//        ll4.selectionsort2();
//        System.out.println(ll4);
        ll4.evenAfterOdd();
        System.out.println(ll4);
        ll4.reverseInGroup(2);
        System.out.println(ll4);
    }
}
