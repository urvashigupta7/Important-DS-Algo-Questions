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

    public void reversePR() {
        reversePR(this.head, this.head.next);
        Node temp = this.head;
        this.head = this.tail;
        this.tail = temp;
        this.tail.next = null;
    }

    private void reversePR(Node prev, Node curr) {
        if (curr == null) {
            return;
        }
        reversePR(prev.next, curr.next);
        curr.next = prev;
    }

    public void reverseDR() {
        reverseDR(new NodeHeap(this.head), this.head, 0);
    }

    private class NodeHeap {
        Node node;

        NodeHeap(Node node) {
            this.node = node;
        }
    }

    private void reverseDR(NodeHeap left, Node right, int count) {
        if (right == null) {
            return;
        }
        reverseDR(left, right.next, count + 1);
        if (count >= this.size / 2) {
            int temp = left.node.data;
            left.node.data = right.data;
            right.data = temp;
        }
        left.node = left.node.next;


    }

    public LinkedList merge(LinkedList two) {
        LinkedList ll = new LinkedList();
        Node head1 = this.head;
        Node head2 = two.head;
        while (head1 != null && head2 != null) {
            if (head1.data < head2.data) {
                ll.addLast(head1.data);
                head1 = head1.next;
            } else {
                ll.addLast(head2.data);
                head2 = head2.next;
            }
        }
        while (head1 != null) {
            ll.addLast(head1.data);
            head1 = head1.next;
        }
        while (head2 != null) {
            ll.addLast(head2.data);
            head2 = head2.next;
        }
        return ll;
    }

    private Node getMidNode() {
        if (this.head == null) {
            return null;
        }
        Node slow = this.head;
        Node fast = this.head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public int getMidData() {
        return getMidNode().data;
    }

    public LinkedList mergesort() throws Exception {
        if (this.size == 1) {
            return this;
        }
        int mid = (this.size / 2);
        Node midnode = this.getMidNode();
        Node midnext = midnode.next;
        LinkedList first = new LinkedList();
        LinkedList second = new LinkedList();
        first.head = this.head;
        first.tail = midnode;
        first.tail.next = null;
        first.size = (this.size + 1) / 2;
        second.head = midnext;
        second.tail = this.tail;
        second.tail.next = null;
        second.size = (this.size) / 2;
        LinkedList lh = first.mergesort();
        LinkedList rh = second.mergesort();
        LinkedList me = lh.merge(rh);
        return me;
    }

    public void bubblesort() {
        bubblesort(this.head, this.head);
    }

    private void bubblesort(Node i, Node j) {
        if (j.next == null) {
            return;
        } else if (i.next == null) {
            bubblesort(this.head, j.next);
            return;
        } else if (i.data > i.next.data) {
            int temp = i.data;
            i.data = i.next.data;
            i.next.data = temp;
        }
        bubblesort(i.next, j);
    }

    public void selectionsort() {
        selectionsort(this.head, this.head.next);
    }

    private void selectionsort(Node i, Node j) {
        if (i.next == null) {
            return;
        }
        if (j == null) {
            selectionsort(i.next, i.next.next);
            return;
        }
        if (i.data > j.data) {
            int temp = i.data;
            i.data = j.data;
            j.data = temp;
        }
        selectionsort(i, j.next);
    }

    public void bubblesort2() {
        Node n1 = this.head;
        for (int i = 0; i < this.size - 1; i++) {
            for (int j = 0; j < this.size - 1 - i; j++) {
                if (n1.data > n1.next.data) {
                    int temp = n1.data;
                    n1.data = n1.next.data;
                    n1.next.data = temp;
                }
                n1 = n1.next;
            }
            n1 = this.head;
        }
    }

    public void selectionsort2() {
        Node n1 = this.head;
        Node n2;
        for (int i = 0; i < this.size; i++) {
            n2 = n1.next;
            for (int j = i + 1; j < this.size; j++) {
                if (n1.data > n2.data) {
                    int temp = n1.data;
                    n1.data = n2.data;
                    n2.data = temp;
                }
                n2 = n2.next;
            }
            n1 = n1.next;
        }
    }

    public boolean isPalindrome() {
        return isPalindrome(new NodeHeap(this.head), this.head);
    }

    private boolean isPalindrome(NodeHeap left, Node right) {
        if (right == null) {
            return true;
        }
        boolean recresult = isPalindrome(left, right.next);
        if (left.node.data != right.data) {
            return false;
        }
        left.node = left.node.next;
        return recresult;
    }

    public void evenAfterOdd() {
        Node ptr = this.head;
        int counteven = 0;
        while (ptr != null) {
            if (ptr.data % 2 == 0) {
                counteven++;
            }
            ptr = ptr.next;
        }
        int i = 0;
        Node prev = this.head;
        Node curr = prev.next;
        while (i < counteven) {
            if (curr.data % 2 == 0) {
                prev.next = curr.next;
                this.tail.next = curr;
                this.tail = curr;
                this.tail.next = null;
                curr = prev.next;
                i++;
            } else {
                prev = prev.next;
                curr = curr.next;
            }
        }
        if (this.head.data % 2 == 0) {
            Node newhead = this.head.next;
            this.tail.next = this.head;
            this.tail = this.head;
            this.tail.next = null;
            this.head = newhead;
        }
    }

    public void reverseInGroup(int k) {
        Node node = reverseInGroup(this.head, k);
        this.head=node;
    }

    private Node reverseInGroup(Node head, int k) {
        Node prev = head;
        Node curr = prev.next;
        int i = 1;
        while (curr != null && i < k) {
            Node temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
            i++;
        }
        if (curr != null) {
            head.next = reverseInGroup(curr, k);
        } else {
            head.next = null;
            this.tail = head;
        }
        return prev;
    }

}
