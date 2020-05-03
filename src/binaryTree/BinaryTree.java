package binaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class BinaryTree {
    public class Node{
        int data;
        Node left;
        Node right;
        public Node(int data) {
            this.data = data;
        }

    }
    private Node root;
    private int size;
    public BinaryTree(){
        Scanner scrn=new Scanner(System.in);
        this.root=construct(scrn,true,null);
    }
    public Node construct(Scanner scrn,boolean isLeft,Node parent){
        if(parent==null){
            System.out.println("Enter the root node data");
        }else if(isLeft){
            System.out.println("Enter the left node data");
        }else{
            System.out.println("Enter the right node data");
        }
        int data=scrn.nextInt();
        Node childNode=new Node(data);
        this.size++;
        System.out.println("Does "+childNode.data+" has left child");
        boolean hasleftchild=scrn.nextBoolean();
        if(hasleftchild){
            childNode.left=construct(scrn,true,childNode);
        }
        System.out.println("Does "+childNode.data+" has left child");
        boolean hasrightchild = scrn.nextBoolean();
        if (hasrightchild) {
            childNode.right = this.construct(scrn, false, childNode);
        }
        return childNode;

    }
    public String toString(){
     return  toString(this.root);
    }
    private String toString(Node node){
        if(node==null){
            return "";
        }
        String str="";
        if(node.left!=null){
            str+=node.left.data+"=>";
        }else{
            str+=null+"=>";
        }
        str+=node.data;
        if(node.right!=null) {
            str += "<=" + node.right.data;
        }else{
            str+="<=null";
        }
        str+="\n";
        str+=toString(node.left);
        str+=toString(node.right);
        return str;
    }
    public int getSize(){
        return this.size;
    }
    public int size2(){
        return size2(this.root);
    }
    public int size2(Node node){
        if(node==null){
            return 0;
        }
        int left=size2(node.left);
        int right=size2(node.right);
        return left+right+1;
    }
    public int max(){
        return max(this.root);
    }
    private int max(Node node){
        if(node==null){
            return 0;
        }
        return Math.max(node.data,Math.max(max(node.left),max(node.right)));
    }
    public boolean search(int data){
       return search(data,this.root);
    }
    private  boolean search(int data, Node node){
        if(node==null){
            return false;
        }
        if(node.data==data){
            return true;
        }
        boolean hasLeft=search(data,node.left);
        if(hasLeft){
            return true;
        }else{
            return search(data,node.right);
        }
    }
    public int height(){
        return height(this.root);
    }
    private  int height(Node node){
        if(node==null){
            return 0;
        }
        int leftHeight=height(node.left);
        int rightHeight=height(node.right);
        return Math.max(leftHeight,rightHeight)+1;
    }
    public void mirror(){
        mirror(this.root);
    }
    private void mirror(Node node){
       if(node==null){
           return;
       }
       Node temp=node.left;
       node.left=node.right;
       node.right=temp;
       mirror(node.left);
       mirror(node.right);
    }
    public void preorder(){
        preorder(this.root);
    }
    private void preorder(Node node){
        if(node==null){
            return;
        }
        System.out.print(node.data+" ");
        preorder(node.left);
        preorder(node.right);
    }
    public void inorder(){
        inorder(this.root);
    }
    private void inorder(Node node){
        if(node==null){
            return;
        }
        inorder(node.left);
        System.out.print(node.data+" ");
        inorder(node.right);
    }
    public void postorder(){
        postorder(this.root);
    }
    private void postorder(Node node){
        if(node==null){
            return;
        }
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.data+" ");
    }
    public void levelorder(){
        Queue <Node>q=new LinkedList<>();
        q.offer(this.root);
        while(!q.isEmpty()){
            Node node=q.poll();
            System.out.print(node.data+" ");
            if(node.left!=null){
                q.offer(node.left);
            }
            if(node.right!=null){
                q.offer(node.right);
            }
        }
        System.out.println();
    }
    public void preorderI(){
        Stack<Node>st=new Stack<>();
        st.push(this.root);
        while(!st.isEmpty()){
            Node node=st.pop();
            System.out.print(node.data+" ");
            if(node.right!=null){
                st.push(node.right);
            }
            if(node.left!=null){
                st.push(node.left);
            }
        }
        System.out.println();
    }
    public void inorderI(){
        Stack<Node>st=new Stack<>();
        Node curr=this.root;
        while(curr!=null || !st.isEmpty()){
            while(curr!=null){
                st.push(curr);
                curr=curr.left;
            }
            curr=st.pop();
            System.out.print(curr.data+" ");
            curr=curr.right;
        }
        System.out.println();
    }
    public int diameter(){
        return diameter(this.root);
    }
    private int diameter(Node node){
        if(node==null){
            return 0;
        }
        int f1=height(node.left)+height(node.right)+1;
        int f2=diameter(node.left);
        int f3=diameter(node.right);
        return  Math.max(f1,Math.max(f2,f3));
    }
    public class DiaPair{
        int height;
        int diameter;
    }
    public int diameterBtr(){
        return diameterBtr(this.root).diameter;
    }
    private DiaPair diameterBtr(Node node){
        if(node==null){
            DiaPair d=new DiaPair();
            d.height=0;
            d.diameter=0;
            return d;
        }
        DiaPair left=diameterBtr(node.left);
        DiaPair right=diameterBtr(node.right);
        DiaPair mr=new DiaPair();
        mr.height=Math.max(left.height,right.height)+1;
        mr.diameter=Math.max(left.height+ right.height+1,Math.max(left.diameter,right.diameter));
        return mr;
    }
}
