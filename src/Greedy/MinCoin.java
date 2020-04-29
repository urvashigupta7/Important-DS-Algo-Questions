package Greedy;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class MinCoin {
    public static void main(String[] args) {
        Scanner scrn=new Scanner(System.in);
        int T=scrn.nextInt();
        Integer []coin={ 1, 2, 5, 10, 20, 50, 100, 200, 500, 2000};
        Arrays.sort(coin, Collections.reverseOrder());
        while(T>0){
            int N=scrn.nextInt();
            int i=0;
            while (N!=0){
                if(N-coin[i]<0){
                    i++;
                }else{
                    System.out.print(coin[i]+" ");
                    N=N-coin[i];
                }
            }
            System.out.println();


            T--;
        }
    }
}
