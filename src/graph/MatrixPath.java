package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class MatrixPath {
    public static void main(String[] args) {
        Scanner scrn = new Scanner(System.in);
        int T = scrn.nextInt();
        while (T > 0) {
            int n = scrn.nextInt();
            int[][] m = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    m[i][j] = scrn.nextInt();
                }
            }
            if(hasPath(m,n)){
                System.out.println(1);
            }else{
                System.out.println(0);
            }
            T--;
        }

    }
    public static boolean isSafe(int i, int j, int[][] m) {
        int N = m.length;
        if ((i < 0 || i >= N) ||
                (j < 0 || j >= N) || m[i][j] == 0)
            return false;
        return true;
    }
    public static boolean hasPath(int [][]m,int n){
        int v=n*n+2;
        graph g=new graph(v);
        int src=-1;
        int dest=-1;
        int k=1;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(m[i][j]!=0){
                    if(isSafe(i,j+1,m)){
                        g.addEdge(k,k+1);
                    }
                    if(isSafe(i,j-1,m)){
                        g.addEdge(k,k-1);
                    }
                    if(isSafe(i-1,j,m)){
                        g.addEdge(k,k-n);
                    }
                    if(isSafe(i+1,j,m)){
                        g.addEdge(k,k+n);
                    }
                }
                if (m[i][j] == 1)
                    src = k;
                if (m[i][j] == 2)
                    dest = k;
                k++;
            }
        }
        return g.hasPathbfs(src,dest);
    }
}
class graph{
    ArrayList<ArrayList<Integer>>vertices;
    public graph(int v){
        vertices=new ArrayList<>();
        for(int i=0;i<v;i++){
            vertices.add(new ArrayList<>());
        }
    }
    public int getnumvertices(){
        return this.vertices.size();
    }
    public void addEdge(int v1,int v2){
        vertices.get(v1).add(v2);
        vertices.get(v2).add(v1);
    }
    public boolean hasPathbfs(int v1,int v2){
        Queue<Integer> q=new LinkedList<>();
        boolean []visited=new boolean[this.getnumvertices()];
        visited[v1]=true;
        q.offer(v1);
        while(!q.isEmpty()){
            int curr=q.poll();
            if(containsEdge(curr,v2)){
                return true;
            }
            ArrayList<Integer>nbrs=vertices.get(curr);
            for(Integer nbr:nbrs){
                if(!visited[nbr]){
                    q.offer(nbr);
                    visited[nbr]=true;
                }
            }
        }
        return false;
    }
    public boolean containsEdge(int v1,int v2){
        ArrayList<Integer> nbrs=vertices.get(v1);
        for(Integer nbr:nbrs){
            if(nbr==v2){
                return true;
            }
        }
        return false;
    }
}

