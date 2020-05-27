package trie;

import java.util.HashMap;
import java.util.Set;

public class Trie {
    public class Node{
        char data;
        boolean isTerminal;
        HashMap<Character,Node>children;
        public Node(char c){
          data=c;
          children=new HashMap<>();
        }
    }
    private Node root;
    private int numWords;
    public Trie(){
        this.root=new Node('\0');
    }
    public int getNumWords(){
        return this.numWords;
    }
    private boolean isEmpty(){
        return this.numWords==0;
    }
    public void add(String str){
        add(str,this.root);
    }
    private void add(String str,Node parent){
        if(str.length()==0){
            if(!parent.isTerminal){
                parent.isTerminal=true;
                numWords++;
            }
            return;
        }
        char cc=str.charAt(0);
        String ros=str.substring(1);
        Node child=parent.children.get(cc);
        if(child==null){
            child=new Node(cc);
            parent.children.put(cc,child);
        }
        add(ros,child);
    }
    public void displayWords(){
        displayWords(this.root,"");
    }
    private void displayWords(Node parent,String ans){
        if(parent.isTerminal){
            System.out.println(ans);
        }
        Set<Character> children=parent.children.keySet();
        for(Character child:children){
            displayWords(parent.children.get(child),ans+child);
        }
    }
    public boolean searchWord(String str){
        return searchWord(str,this.root);
    }
    private boolean searchWord(String str,Node parent){
        if(str.length()==0){
            if(parent.isTerminal){
                return true;
            }
            return false;
        }
        char cc=str.charAt(0);
        String ros=str.substring(1);
        Node child=parent.children.get(cc);
        if(child==null){
            return false;
        }else{
            return searchWord(ros,child);
        }
    }
    public void remove(String str){
        remove(str,this.root);
    }
    private void remove(String str,Node parent){
        if(str.length()==0){
            if(parent.isTerminal){
                numWords--;
                parent.isTerminal=false;
            }
            return;
        }
        char cc=str.charAt(0);
        String ros=str.substring(1);
        Node child=parent.children.get(cc);
        remove(ros,child);
        if(!child.isTerminal&&child.children.size()==0){
            parent.children.remove(cc);
        }
    }
    public void displayStartsWith(String pattern) {
        displayStartsWith(root, pattern, pattern);
    }

    private void displayStartsWith(Node node, String pattern, String org) {
        if (pattern.length() == 0) {
            displayWords(node, org);
            return;
        }

        char cc = pattern.charAt(0);
        String ros = pattern.substring(1);

        Node child = node.children.get(cc);

        displayStartsWith(child, ros, org);

    }


}
