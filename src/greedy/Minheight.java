package greedy;

import java.util.Arrays;
import java.util.Scanner;

public class Minheight {
    public static void main(String[] args) {
        Scanner scrn = new Scanner(System.in);
        int T = scrn.nextInt();
        while (T > 0) {
            int K = scrn.nextInt();
            int N = scrn.nextInt();
            int[] A = new int[N];
            for (int i = 0; i < N; i++) {
                A[i] = scrn.nextInt();
            }
            Arrays.sort(A);
            int ans = A[N - 1] - A[0];
            int sm = A[0] + K;
            int big = A[N - 1] - K;
            int temp = 0;
            if (sm > big) {
                temp = sm;
                sm = big;
                big = temp;
            }
            for(int i=1;i<N-1;i++){
                int add=A[i]+K;
                int sub=A[i]-K;
                if(sub>=sm || add<=big){
                    continue;
                }
                if(big-sub>add-sm){
                    big=add;
                }else {
                    sm=sub;
                }

                ans=Math.min(ans,big-sm);
            }
            ans=Math.min(ans,big-sm);
            System.out.println(ans);
            T--;
        }
    }
}
