package greedy;

import java.util.Arrays;
import java.util.Scanner;

public class MinPlatform {
    public static void main(String[] args) {
        Scanner scrn=new Scanner(System.in);
        int T=scrn.nextInt();
        while(T>0){
            int N=scrn.nextInt();
            int []A=new int[N];
            int []D=new int[N];
            for(int i=0;i<N;i++) {
                A[i] = scrn.nextInt();
            }
            for(int i=0;i<N;i++){
                D[i]=scrn.nextInt();
            }
            Arrays.sort(A);
            Arrays.sort(D);
            int platform=1;
            int i=1;
            int j=0;
            int ans=Integer.MIN_VALUE;
            while(i<N&&j<N){
                if(A[i]<=D[j]){
                    platform++;
                    i++;
                }
                else{
                    platform--;
                    j++;
                }
                ans=Math.max(ans,platform);
            }
            System.out.println(ans);

            T--;
        }
    }
}
