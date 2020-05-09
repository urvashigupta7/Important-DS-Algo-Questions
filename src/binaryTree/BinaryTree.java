package binaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class BinaryTree {
    public class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }

    }

    private Node root;
    private int size;

    public BinaryTree() {
        Scanner scrn = new Scanner(System.in);
        this.root = construct(scrn, true, null);
    }
    public BinaryTree(int []pre,int []post){
        this.root=create(pre,post,0,post.length-1,new Pindex());
    }
    private class Pindex{
        int pindex;
    }
    public Node create(int []pre,int []post,int pstart,int pend,Pindex p){
        if(pstart>pend||p.pindex>=pre.length){
            return null;
        }
        Node newnode=new Node(pre[p.pindex]);
        p.pindex++;
        if(p.pindex>=pre.length||pstart==pend){
            return newnode;
        }
        int i;
        for( i=pstart;i<=pend;i++){
            if(pre[p.pindex]==post[i]){
                break;
            }
        }
        if(i<=pend) {
            newnode.left = create(pre, post, pstart, i, p);
            newnode.right = create(pre, post, i + 1, pend, p);
        }
        return newnode;
    }
//    public Node create(int []pre,int []in,int prestart,int preend,int instart,int inend){
//        if(prestart>preend||instart>inend){
//            return null;
//        }
//        Node newnode=new Node(pre[prestart]);
//        int searchindex=-1;
//        for(int i=instart;i<=inend;i++){
//            if(in[i]==pre[prestart]){
//                searchindex=i;
//                break;
//            }
//        }
//        int nel=searchindex-instart;
//        newnode.left=create(pre,in,prestart+1,prestart+nel,instart,searchindex-1);
//        newnode.right=create(pre,in,prestart+nel+1,preend,searchindex+1,inend);
//        return newnode;
//    }

    public Node construct(Scanner scrn, boolean isLeft, Node parent) {
        if (parent == null) {
            System.out.println("Enter the root node data");
        } else if (isLeft) {
            System.out.println("Enter the left node data");
        } else {
            System.out.println("Enter the right node data");
        }
        int data = scrn.nextInt();
        Node childNode = new Node(data);
        this.size++;
        System.out.println("Does " + childNode.data + " has left child");
        boolean hasleftchild = scrn.nextBoolean();
        if (hasleftchild) {
            childNode.left = construct(scrn, true, childNode);
        }
        System.out.println("Does " + childNode.data + " has left child");
        boolean hasrightchild = scrn.nextBoolean();
        if (hasrightchild) {
            childNode.right = this.construct(scrn, false, childNode);
        }
        return childNode;

    }

    public String toString() {
        return toString(this.root);
    }

    private String toString(Node node) {
        if (node == null) {
            return "";
        }
        String str = "";
        if (node.left != null) {
            str += node.left.data + "=>";
        } else {
            str += null + "=>";
        }
        str += node.data;
        if (node.right != null) {
            str += "<=" + node.right.data;
        } else {
            str += "<=null";
        }
        str += "\n";
        str += toString(node.left);
        str += toString(node.right);
        return str;
    }

    public int getSize() {
        return this.size;
    }

    public int size2() {
        return size2(this.root);
    }

    public int size2(Node node) {
        if (node == null) {
            return 0;
        }
        int left = size2(node.left);
        int right = size2(node.right);
        return left + right + 1;
    }

    public int max() {
        return max(this.root);
    }

    private int max(Node node) {
        if (node == null) {
            return 0;
        }
        return Math.max(node.data, Math.max(max(node.left), max(node.right)));
    }

    public boolean search(int data) {
        return search(data, this.root);
    }

    private boolean search(int data, Node node) {
        if (node == null) {
            return false;
        }
        if (node.data == data) {
            return true;
        }
        boolean hasLeft = search(data, node.left);
        if (hasLeft) {
            return true;
        } else {
            return search(data, node.right);
        }
    }

    public int height() {
        return height(this.root);
    }

    private int height(Node node) {
        if (node == null) {
            return 0;
        }
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public void mirror() {
        mirror(this.root);
    }

    private void mirror(Node node) {
        if (node == null) {
            return;
        }
        Node temp = node.left;
        node.left = node.right;
        node.right = temp;
        mirror(node.left);
        mirror(node.right);
    }

    public void preorder() {
        preorder(this.root);
    }

    private void preorder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + " ");
        preorder(node.left);
        preorder(node.right);
    }

    public void inorder() {
        inorder(this.root);
    }

    private void inorder(Node node) {
        if (node == null) {
            return;
        }
        inorder(node.left);
        System.out.print(node.data + " ");
        inorder(node.right);
    }

    public void postorder() {
        postorder(this.root);
    }

    private void postorder(Node node) {
        if (node == null) {
            return;
        }
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.data + " ");
    }

    public void levelorder() {
        Queue<Node> q = new LinkedList<>();
        q.offer(this.root);
        while (!q.isEmpty()) {
            Node node = q.poll();
            System.out.print(node.data + " ");
            if (node.left != null) {
                q.offer(node.left);
            }
            if (node.right != null) {
                q.offer(node.right);
            }
        }
        System.out.println();
    }

    public void preorderI() {
        Stack<Node> st = new Stack<>();
        st.push(this.root);
        while (!st.isEmpty()) {
            Node node = st.pop();
            System.out.print(node.data + " ");
            if (node.right != null) {
                st.push(node.right);
            }
            if (node.left != null) {
                st.push(node.left);
            }
        }
        System.out.println();
    }

    public void inorderI() {
        Stack<Node> st = new Stack<>();
        Node curr = this.root;
        while (curr != null || !st.isEmpty()) {
            while (curr != null) {
                st.push(curr);
                curr = curr.left;
            }
            curr = st.pop();
            System.out.print(curr.data + " ");
            curr = curr.right;
        }
        System.out.println();
    }

    public int diameter() {
        return diameter(this.root);
    }

    private int diameter(Node node) {
        if (node == null) {
            return 0;
        }
        int f1 = height(node.left) + height(node.right) + 1;
        int f2 = diameter(node.left);
        int f3 = diameter(node.right);
        return Math.max(f1, Math.max(f2, f3));
    }

    public class DiaPair {
        int height;
        int diameter;
    }

    public int diameterBtr() {
        return diameterBtr(this.root).diameter;
    }

    private DiaPair diameterBtr(Node node) {
        if (node == null) {
            DiaPair d = new DiaPair();
            d.height = 0;
            d.diameter = 0;
            return d;
        }
        DiaPair left = diameterBtr(node.left);
        DiaPair right = diameterBtr(node.right);
        DiaPair mr = new DiaPair();
        mr.height = Math.max(left.height, right.height) + 1;
        mr.diameter = Math.max(left.height + right.height + 1, Math.max(left.diameter, right.diameter));
        return mr;
    }

    public boolean isBst() {
        return isBst(this.root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isBst(Node node, int min, int max) {
        if (node == null) {
            return true;
        }
        if (min > node.data || node.data > max) {
            return false;
        }
        boolean isLeftBST = isBst(node.left, min, node.data);
        boolean isrightBST = isBst(node.right, node.data, max);
        return isLeftBST && isrightBST;
    }

    public boolean isBalanced() {
        return isBalanced(this.root);
    }

    private boolean isBalanced(Node node) {
        if (node == null) {
            return true;
        }
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return false;
        }
        return isBalanced(node.left) && isBalanced(node.right);
    }

    private class BalancedPair {
        int height;
        boolean isBalanced;
    }

    public boolean isBalancedbtr() {
        return isBalancedbtr(this.root).isBalanced;
    }

    private BalancedPair isBalancedbtr(Node node) {
        if (node == null) {
            BalancedPair b = new BalancedPair();
            b.height = 0;
            b.isBalanced = true;
            return b;
        }
        BalancedPair left = isBalancedbtr(node.left);
        BalancedPair right = isBalancedbtr(node.right);
        BalancedPair mr = new BalancedPair();
        mr.height = Math.max(left.height, right.height) + 1;
        if (Math.abs(left.height - right.height) > 1) {
            mr.isBalanced = false;
        } else {
            mr.isBalanced = left.isBalanced && right.isBalanced;
        }
        return mr;
    }

    private class Composite {
        int height;
        int max;
        int min;
        int diameter;
        int size;
    }

    public Composite multiSolver() {
        return multiSolver(this.root);
    }

    private Composite multiSolver(Node node) {
        if (node == null) {
            Composite c = new Composite();
            c.height = 0;
            c.max = Integer.MIN_VALUE;
            c.min = Integer.MAX_VALUE;
            c.size = 0;
            c.diameter = 0;
        }
        Composite left = multiSolver(node.left);
        Composite right = multiSolver(node.right);
        Composite mr = new Composite();
        mr.height = Math.max(left.height, right.height) + 1;
        mr.max = Math.max(left.max, Math.max(node.data, right.max));
        mr.min = Math.min(left.min, Math.min(right.min, node.data));
        mr.size = left.height + right.height + 1;
        mr.diameter = Math.max(left.height + right.height + 1, Math.max(left.diameter, right.diameter));
        return mr;
    }

    public boolean isIdentical(BinaryTree b) {
        return isIdentical(this.root, b.root);
    }

    private boolean isIdentical(Node node1, Node node2) {
        if (node1 == null && node2 == null) {
            return true;
        } else if (node1 != null && node2 != null) {
            return isIdentical(node1.left, node2.left) && isIdentical(node1.right, node2.right);
        } else {
            return false;
        }
    }

    public void levelOrderLW() {
        Queue<Node> pqueue = new LinkedList<>();
        Queue<Node> cqueue = new LinkedList<>();
        pqueue.offer(this.root);
        while (!pqueue.isEmpty()) {
            Node node = pqueue.poll();
            System.out.print(node.data + " ");
            if (node.left != null) {
                cqueue.offer(node.left);
            }
            if (node.right != null) {
                cqueue.offer(node.right);
            }
            if (pqueue.isEmpty()) {
                pqueue = cqueue;
                cqueue = new LinkedList<>();
                System.out.println();
            }
        }

    }

    public void zigzag() {
        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();
        boolean lefttoright = true;
        stack1.push(this.root);
        while (!stack1.isEmpty()) {
            Node n = stack1.pop();
            System.out.print(n.data + " ");
            if (lefttoright) {
                if (n.left != null) {
                    stack2.push(n.left);
                }
                if (n.right != null) {
                    stack2.push(n.right);
                }
            } else {
                if (n.right != null) {
                    stack2.push(n.right);
                }
                if (n.left != null) {
                    stack2.push(n.left);
                }

            }
            if (stack1.isEmpty()) {
                stack1 = stack2;
                stack2 = new Stack<>();
                System.out.println();
                lefttoright = !lefttoright;
            }
        }

    }

    public int lca(int a,int b) {
        return lca(this.root,a,b).data;
    }
    private Node lca(Node node,int a,int b){
        if(node==null){
            return null;
        }
        if(node.data==a||node.data==b){
            return node;
        }
        Node left=lca(node.left,a,b);
        Node right=lca(node.right,a,b);
        if(left==null&&right==null){
            return null;
        }else if(left==null&&right!=null){
            return left;
        }else if(right==null&&left!=null){
            return left;
        }else{
            return node;
        }
    }
    public void removeleaves(){
        removeleaves(this.root);
    }
    private void removeleaves(Node node){
        if(node==null){
            return;
        }
        if(node.left.left==null&&node.left.right==null){
            node.left=null;
        }
        if(node.right.left==null&&node.right.right==null){
            node.right=null;
        }
        removeleaves(node.left);
        removeleaves(node.right);
    }
    private class LargestBSTHelper{
        int min;
        int max;
        int size;
        boolean isBST;
        int ans;
    }
    public int largestBSTHelper(){
        return largestBSTHelper(this.root).ans;
    }
    private LargestBSTHelper largestBSTHelper(Node node){
        if(node==null){
           LargestBSTHelper l=new LargestBSTHelper();
           l.min=Integer.MAX_VALUE;
           l.max=Integer.MIN_VALUE;
           l.size=0;
           l.ans=0;
           l.isBST=true;
           return l;
        }
        LargestBSTHelper left=largestBSTHelper(node.left);
        LargestBSTHelper right=largestBSTHelper(node.right);
        LargestBSTHelper mr=new LargestBSTHelper();
        mr.min=Math.min(left.min,Math.max(right.min,node.data));
        mr.max=Math.max(left.max,Math.max(right.max,node.data));
        mr.size=left.size+right.size+1;
        if(left.isBST&&right.isBST&&node.data>left.max &&node.data<right.min){
          mr.isBST=true;
          mr.ans=mr.size;
        }else {
           mr.isBST=false;
           mr.ans=Math.max(left.ans,right.ans);
        }
        return mr;
    }
    public void replaceWgSum(){
        replaceWgSum(this.root,new Sum());
    }
    private void  replaceWgSum(Node node,Sum sum){
        if(node==null){
            return;
        }
        replaceWgSum(node.right,sum);
        int temp=node.data;
        node.data+=sum.sum;
        sum.sum+=temp;
        replaceWgSum(node.left,sum);

    }
    private class Sum{
        int sum;
    }
    private void kdown(Node node,int k){
        if(node==null){
            return;
        }
        if(k==0){
            System.out.print(node.data+" ");
        }
        kdown(node.left,k-1);
        kdown(node.right,k-1);
    }
    public void kfar(int target,int k){
        kfar(this.root,target,k);
    }
    private int kfar(Node node,int target,int k){
        if(node==null){
            return 0;
        }
        if(node.data==target){
            kdown(node,k);
            return 0;
        }
        int dl=kfar(node.left,target,k);
        if(dl!=-1){
            if(dl+1==k){
                System.out.print(node.data+" ");
            }else{
                kdown(node.right,k-dl-2);
            }
            return dl+1;
        }
        int dr=kfar(node.right,target,k);
        if(dr!=-1){
            if(dr+1==k){
                System.out.println(node.data+" ");
            }else{
                kdown(node.left,k-dr-2);
            }
            return dr+1;
        }
        return -1;
    }
    public int maxsumpath(){
        Max m=new Max();
        m.max=Integer.MIN_VALUE;
        maxsumpath(this.root,m);
        return m.max;
    }
    private int maxsumpath(Node node, Max m){
        if(node==null){
          return 0;
        }
        int left=maxsumpath(node.left,m);
        int right=maxsumpath(node.right,m);
        int maxSingleChild=Math.max(Math.max(left,right)+node.data,node.data);
        int withroot=Math.max(node.data+left+right,maxSingleChild);
        m.max=Math.max(m.max,withroot);
        return maxSingleChild;
    }
    private class Max{
        int max;
    }

}
