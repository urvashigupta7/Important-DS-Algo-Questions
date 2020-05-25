package graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class KnightWalk {
    public static void main(String[] args) {
        Scanner scrn=new Scanner(System.in);
        int T=scrn.nextInt();
        while(T>0){
            int N=scrn.nextInt();
            int M=scrn.nextInt();
            int s1=scrn.nextInt();
            int s2=scrn.nextInt();
            int d1=scrn.nextInt();
            int d2=scrn.nextInt();
            int []mx={-1,-1,1,1,2,2,-2,-2};
            int []my={2,-2,-2,2,-1,1,-1,1};
            Gnode start=new Gnode(s1,s2,0);
            Queue<Gnode>q=new LinkedList<>();
            boolean [][]visited=new boolean[N+1][M+1];
            visited[s1][s2]=true;
            q.offer(start);
            boolean ans=false;
            while (!q.isEmpty()){
                Gnode curr=q.poll();
                if(curr.x1==d1&&curr.x2==d2){
                    System.out.println(curr.dist);
                    ans=true;
                    break;
                }
                for(int i=0;i<mx.length;i++){
                    int x=curr.x1+mx[i];
                    int y=curr.x2+my[i];
                    if(x<=N&&y<=M&&x>0&&y>0&&!visited[x][y]){
                        q.offer(new Gnode(x,y,curr.dist+1));
                        visited[x][y]=true;
                    }
                }
            }
            if(!ans){
                System.out.println(-1);
            }
            T--;
        }
    }
}
class Gnode{
    int x1;
    int x2;
    int dist;
    public Gnode(int x1,int x2,int dist){
        this.x1=x1;
        this.x2=x2;
        this.dist=dist;
    }
}