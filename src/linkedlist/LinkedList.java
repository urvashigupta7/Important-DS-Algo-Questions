package linkedlist;

public class LinkedList {
    private class Node {
        int data;
        Node next;

        Node(int data, Node n) {
            this.data = data;
            this.next = n;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public boolean isEmpty() {
        return this.size == 0;
    }

    public int getSize() {
        return this.size;
    }

    public String toString() {
        Node ptr = this.head;
        StringBuilder sb = new StringBuilder();
        while (ptr != null) {
            sb.append(ptr.data);
            sb.append("=>");
            ptr = ptr.next;
        }
        sb.append("null");
        return sb.toString();
    }

    public void addLast(int data) {
        if (isEmpty()) {
            addifEmpty(data);
        } else {
            Node newnode = new Node(data, null);
            this.tail.next = newnode;
            this.tail = newnode;
            size++;
        }
    }

    public void addifEmpty(int data) {
        Node newnode = new Node(data, null);
        this.head = this.tail = newnode;
        size++;
    }

    public void addaAtBeg(int data) {
        if (isEmpty()) {
            addifEmpty(data);
        } else {
            Node newnode = new Node(data, this.head);
            this.head = newnode;
            size++;
        }
    }

    public int getfirst() throws Exception {
        if (isEmpty()) {
            throw new Exception("LinkedList Empty");
        } else {
            return this.head.data;
        }
    }

    public int getlast() throws Exception {
        if (isEmpty()) {
            throw new Exception("LinkedList Empty");
        } else {
            return this.tail.data;
        }
    }

    public int getAt(int index) throws Exception {
        return getNodeAt(index).data;
    }

    private Node getNodeAt(int index) throws Exception {
        if (index < 0 || index >= size) {
            throw new Exception("Invalid Index");
        } else {
            Node ptr = this.head;
            int i = 0;
            while (i != index) {
                ptr = ptr.next;
                i++;
            }
            return ptr;
        }
    }

    public void addAt(int index, int data) throws Exception {
        Node pre = getNodeAt(index - 1);
        Node curr = getNodeAt(index);
        Node newnode = new Node(data, curr);
        pre.next = newnode;
        size++;
    }

    public int removeAtBeg() throws Exception {
        if (isEmpty()) {
            throw new Exception("LinkedList Empty");
        } else if (this.size == 1) {
            int data = this.head.data;
            this.head = this.tail = null;
            size--;
            return data;
        } else {
            int data = this.head.data;
            this.head = this.head.next;
            size--;
            return data;
        }
    }

    public int removeLast() throws Exception {
        if (isEmpty()) {
            throw new Exception("LinkedList Empty");
        } else if (this.size == 1) {
            int data = this.head.data;
            this.head = this.tail = null;
            return data;
        } else {
            int data = this.tail.data;
            Node secondlast = getNodeAt(this.size - 2);
            secondlast.next = null;
            this.tail = secondlast;
            size--;
            return data;
        }
    }

    public int removeAt(int index) throws Exception {
        if (index < 0 && index >= size) {
            throw new Exception("LinkedList Empty");
        } else if (index == 0) {
            return removeAtBeg();
        } else if (index == this.size - 1) {
            return removeLast();
        } else {
            Node pre = getNodeAt(index - 1);
            Node curr = getNodeAt(index);
            int data = curr.data;
            pre.next = curr.next;
            size--;
            return data;
        }
    }

    public int linearSearch(int data) {
        Node ptr = this.head;
        int i = 0;
        for (i = 0; i < this.size; i++) {
            if (ptr.data == data) {
                break;
            }
            ptr = ptr.next;
        }
        if (i == this.size) {
            return -1;
        }
        return i;
    }

    public void displayReverse() {
        displayReverse(this.head);
    }

    private void displayReverse(Node ptr) {
        if (ptr == null) {
            return;
        }
        displayReverse(ptr.next);
        System.out.println(ptr.data);
    }

    public void reverseDI() throws Exception {
        for (int i = 0; i < this.size / 2; i++) {
            Node left = getNodeAt(i);
            Node right = getNodeAt(this.size - 1 - i);
            int temp = left.data;
            left.data = right.data;
            right.data = temp;
        }
    }

    public void reversePI() {
        Node prev = this.head;
        Node curr = prev.next;
        while (curr != null) {
            Node temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        Node temp = this.head;
        this.head = this.tail;
        this.tail = temp;
        this.tail.next = null;

    }
    public void reversePR(){
        reversePR(this.head,this.head.next);
        Node temp=this.head;
        this.head=this.tail;
        this.tail=temp;
        this.tail.next=null;
    }
    private void reversePR(Node prev,Node curr){
        if(curr==null){
            return;
        }
        reversePR(prev.next,curr.next);
        curr.next=prev;
    }

}
