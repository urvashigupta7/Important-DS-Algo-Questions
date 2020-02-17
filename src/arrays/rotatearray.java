package arrays;

import java.util.Scanner;

public class rotatearray {
    public static void main(String[] args) {
        Scanner scrn=new Scanner(System.in);
        int T=scrn.nextInt();
        while(T>0){
            int N=scrn.nextInt();
            int D=scrn.nextInt();
            int []arr=new int[N];
            for(int i=0;i<N;i++){
                arr[i]=scrn.nextInt();
            }
            for(int i=0;i<N;i++){
                System.out.print(arr[(i+D)%N]+" ");
            }
            System.out.println();

            T--;
        }
        int N=scrn.nextInt();
    }
}
