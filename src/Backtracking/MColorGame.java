package Backtracking;

import java.util.Scanner;

public class MColorGame {
    public static void main(String[] args) {
        Scanner scrn=new Scanner(System.in);
        int T=scrn.nextInt();
        while(T>0){
            int N=scrn.nextInt();
            int [][]m=new int[N+1][N+1];
            int M=scrn.nextInt();
            int E=scrn.nextInt();
            for(int i=0;i<E;i++){
                int a=scrn.nextInt();
                int b=scrn.nextInt();
                m[a][b]=1;
                m[b][a]=1;
            }
            int []color=new int[N+1];
            if(isPossible(m,color,M,N,1)){
                for(int i=0;i<N;i++){
                    System.out.print(color[i]+" ");
                }
                System.out.println();
            }else{
                System.out.println(0);
            }

            T--;
        }
    }
    public static boolean isPossible(int [][]m,int []color,int M,int totalVertices,int pos){
        if(pos==totalVertices+1){
            return true;
        }
        for(int i=1;i<=M;i++){
            if(isSafe(color,m,pos,totalVertices,i)){
                color[pos]=i;
                if(isPossible(m,color,M,totalVertices,pos+1)){
                    return true;
                }
                color[pos]=0;
            }
        }
        return false;
    }
    public static boolean isSafe(int []color,int [][]m,int v,int N,int currcolor){
        for(int i=1;i<=N;i++){
            if(m[v][i]==1&&color[i]==currcolor){
                return false;
            }
        }
        return true;
    }
}
