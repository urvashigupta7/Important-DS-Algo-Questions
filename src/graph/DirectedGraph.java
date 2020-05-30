package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class DirectedGraph {
    int V;
    ArrayList<ArrayList<Integer>>vertices=new ArrayList<>();
    public DirectedGraph(int v){
        this.V=v;
        for(int i=0;i<v;i++){
            vertices.add(new ArrayList<>());
        }
    }
    public void addEdge(int v1,int v2){
        vertices.get(v1).add(v2);
    }
    public void printSCC(){
        Stack<Integer>st=new Stack<>();
        boolean [] visited=new  boolean[V];
        for(int i=0;i<V;i++){
            if(!visited[i]){
                fill(i,st,visited);
            }
        }
        DirectedGraph transposeGraph=createTransposeGraph();
        Arrays.fill(visited,false);
        while (!st.isEmpty()){
            int curr=st.pop();
            if(!visited[curr]) {
                dfs(curr, visited,transposeGraph);
            }
            System.out.println();
        }

    }
    private void dfs(int curr, boolean []visited, DirectedGraph tg){
        visited[curr]=true;
        System.out.print(curr+" ");
        ArrayList<Integer>nbrs=tg.vertices.get(curr);
        for(Integer nbr:nbrs){
            if(!visited[nbr]){
                dfs(nbr,visited,tg);
            }
        }
    }
    private void fill(int v,Stack<Integer>st,boolean []visited){
        visited[v]=true;
        ArrayList<Integer>nbrs=vertices.get(v);
        for(Integer nbr:nbrs){
            if(!visited[nbr]) {
                fill(nbr, st, visited);
            }
        }
        st.push(v);
    }
    private DirectedGraph createTransposeGraph(){
        DirectedGraph g=new DirectedGraph(V);
        for(int i=0;i<V;i++){
            ArrayList<Integer>nbrs=vertices.get(i);
            for(Integer nbr:nbrs){
                g.vertices.get(nbr).add(i);
            }
        }
        return g;
    }

    public static void main(String[] args) {
        DirectedGraph ug=new DirectedGraph(5);
        ug.addEdge(1, 0);
        ug.addEdge(0, 2);
        ug.addEdge(2, 1);
        ug.addEdge(0, 3);
        ug.addEdge(3, 4);
        ug.printSCC();
    }
}
