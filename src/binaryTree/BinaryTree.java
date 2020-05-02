package binaryTree;

import java.util.Scanner;

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
}
