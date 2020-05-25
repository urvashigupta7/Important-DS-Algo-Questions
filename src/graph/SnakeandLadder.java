package graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SnakeandLadder {
    public static void main(String[] args) {
        Scanner scrn=new Scanner(System.in);
        int T=scrn.nextInt();
        while(T>0){
            int []m=new int[31];
            int N=scrn.nextInt();
            for(int i=0;i<N;i++){
                int pos=scrn.nextInt();
                int dest=scrn.nextInt();
                m[pos]=dest;
            }
            boolean []visited=new boolean[31];
            Cell src=new Cell(1,0);
            visited[1]=true;
            Queue<Cell>q=new LinkedList<>();
            q.offer(src);
            while (!q.isEmpty()){
                Cell curr=q.poll();
                if(curr.v==30){
                    System.out.println(curr.dist);
                    break;
                }
                for(int i=1;i<=6;i++){
                    if(curr.v+i<31&&!visited[curr.v+i]){
                     Cell c=new Cell(0,curr.dist+1);
                     visited[curr.v+i]=true;
                     if(m[curr.v+i]!=0){
                         c.v=m[curr.v+i];
                     }else{
                         c.v=curr.v+i;
                     }
                     q.offer(c);
                    }
                }
            }
            T--;
        }
    }
}
class Cell{
    int v;
    int dist;
    public Cell(int v,int dist){
        this.v=v;
        this.dist=dist;
    }
}