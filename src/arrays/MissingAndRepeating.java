package arrays;

import java.util.Scanner;

public class MissingAndRepeating {
    public static void main(String[] args) {
        Scanner scrn=new Scanner(System.in);
        int T=scrn.nextInt();
        while(T>0){
            int N=scrn.nextInt();
            int []A=new int[N+1];
            for(int i=1;i<=N;i++){
                A[i]=scrn.nextInt();
            }
            for(int i=1;i<=N;i++){
                int val=Math.abs(A[i]);
                if(A[val]<0){
                    System.out.print(val+" ");
                }else{
                    A[val]=-A[val];
                }
            }
            for(int i=1;i<=N;i++){
                if(A[i]>0){
                    System.out.println(i);
                }
            }


            T--;
        }
    }
}
