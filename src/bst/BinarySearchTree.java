package bst;

import binaryTree.BinaryTree;

public class BinarySearchTree {
    private class Node{
        int data;
        Node left;
        Node right;
        public Node(int d){
            this.data=d;
        }
    }
    private Node root;
    private int size;
    public int getSize(){
        return this.size;
    }
    public String toString(){
        return toString(this.root);
    }
    public String toString(Node node){
        if(node==null){
            return "";
        }
        String str="";
        if(node.left!=null){
            str+=node.left.data+"=>";
        }
        else{
            str+="null=>";
        }
        str+=node.data;
        if(node.right!=null){
            str+="<="+node.right.data;
        }else{
            str+="<=null";
        }
        str+="\n";
        str+=toString(node.left);
        str+=toString(node.right);
        return str;
    }
    public BinarySearchTree(int []in){
        this.root=create(in,0,in.length-1);
        this.size=in.length;
    }
    private Node create(int []in,int instart,int inend){
        if(instart>inend){
            return null;
        }
        int mid=(instart+inend)/2;
        Node newnode=new Node(in[mid]);
        newnode.left=create(in,instart,mid-1);
        newnode.right=create(in,mid+1,inend);
        return newnode;
    }
    public boolean find(int data){
        return find(this.root,data);
    }
    private boolean find(Node node, int data){
        if(node==null){
            return false;
        }
        if(node.data==data){
            return true;
        }
        if(data>node.data){
            return find(node.right,data);
        }else{
            return find(node.left,data);
        }
    }
    public int max(){
        return max(this.root);
    }
    private int max(Node node){
        if(node.right==null){
            return node.data;
        }
        return max(node.right);
    }
    public void add(int data){
        this.root=add(this.root,data);
        return;
    }
    private Node add(Node node,int data){
        if(node==null){
            Node newnode=new Node(data);
            this.size++;
            return newnode;
        }
        if(data>=node.data){
            node.right=add(node.right,data);
        }
        else{
            node.left=add(node.left,data);
        }
        return node;
    }
    public void remove(int data){
        this.root=remove(this.root,data);
        return;
    }
    private Node remove(Node node,int data){
        if(node==null){
            return null;
        }
        if(data>node.data){
            node.right=remove(node.right,data);
        }else if(data<node.data){
            node.left=remove(node.left,data);
        }else{
            if(node.left==null&&node.right==null){
                node=null;
            }else if(node.left!=null&&node.right!=null){
                int max=max(node.left);
                node.data=max;
                node.left=remove(node.left,max);
            }else if(node.left==null&&node.right!=null){
                node=node.right;
            }else{
                node=node.left;
            }
        }
        return node;
    }
    public int lca(int n1,int n2){
        return lca(this.root,n1,n2).data;
    }
    private Node lca(Node node,int n1,int n2){
        if(node==null){
            return null;
        }
        if(n1>node.data&&n2>node.data){
            return lca(node.right,n1,n2);
        }
        if(n1<node.data&&n2<node.data){
            return lca(node.left,n1,n2);
        }
        return node;
    }

}
