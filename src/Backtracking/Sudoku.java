package Backtracking;

import java.util.Scanner;

public class Sudoku {
    public static void main(String[] args) {
        Scanner scrn=new  Scanner(System.in);
        int T=scrn.nextInt();
        while(T>0){
            int [][]m=new int[9][9];
            for(int i=0;i<9;i++){
                for(int j=0;j<9;j++){
                    m[i][j]=scrn.nextInt();
                }
            }
            solve(0,0,m);
            T--;
        }
    }
    public static void display(int [][]m){
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                System.out.print(m[i][j]+" ");;
            }
            System.out.println();;
        }
    }
    public static void solve(int i,int j,int [][]m){
        if(i==9){
            display(m);
            return;
        }
        if(j==9){
            solve(i+1,0,m);
            return;
        }
        if(m[i][j]==0){
            for(int k=1;k<=9;k++){
                if(isSafe(k,m,i,j)){
                    m[i][j]=k;
                    solve(i,j+1,m);
                    m[i][j]=0;
                }
            }
        }else{
            solve(i,j+1,m);
        }
    }
    public static boolean isSafe(int k,int [][]m,int i,int j){
        for(int a=0;a<9;a++){
         if(m[i][a]==k){
             return false;
         }
        }
        for(int a=0;a<9;a++){
            if(m[a][j]==k){
                return false;
            }
        }
        int rblock=i/3;
        int colblock=j/3;
        for(int a=rblock*3;a<(rblock+1)*3;a++){
            for(int b=colblock*3;b<(colblock+1)*3;b++){
                if(m[a][b]==k){
                    return false;
                }
            }
        }
        return true;
    }
}
