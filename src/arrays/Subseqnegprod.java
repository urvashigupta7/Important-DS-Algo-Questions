package arrays;

import java.util.Scanner;

public class Subseqnegprod {
    public static void main(String[] args) {
        Scanner scrn=new Scanner(System.in);
        int T=scrn.nextInt();
        while(T>0){
            int N=scrn.nextInt();
            int []A=new int[N];
            for(int i=0;i<N;i++){
                A[i]=scrn.nextInt();
            }
            int count_neg=0;
            for(int i=0;i<N;i++){
                if(A[i]<0){
                    count_neg++;
                }
            }
            long totalnegcomb=calcpow(2,count_neg-1);
            long totalposcomb=calcpow(2,N-count_neg);
            int m=1000000007;

            System.out.println((totalnegcomb*totalposcomb)%m);
            T--;
        }
    }
    public static long calcpow(int n,int k){
        if(k==0){
            return 1;
        }
        if(k==1){
            return n;
        }
        long recresult=calcpow(n,k/2);
        if(k%2==0){
            return recresult*recresult;
        }else{
            return n*recresult*recresult;
        }
    }
}
