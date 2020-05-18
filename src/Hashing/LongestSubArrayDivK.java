package Hashing;

import java.util.HashMap;
import java.util.Scanner;

public class LongestSubArrayDivK {
    public static void main(String[] args) {
        Scanner scrn=new Scanner(System.in);
        int T=scrn.nextInt();
        while(T>0){
            int N=scrn.nextInt();
            int K=scrn.nextInt();
            int []A=new int[N];
            for(int i=0;i<N;i++){
                A[i]=scrn.nextInt();
            }
            int currsum=0;
            int max=Integer.MIN_VALUE;
            HashMap<Integer,Integer>map=new HashMap<>();
            for(int i=0;i<N;i++){
                currsum+=A[i];
                int mod=((currsum % K) + K) % K;
                if(mod==0){
                    max=Math.max(max,i+1);
                }
                if(map.containsKey(mod)){
                    max=Math.max(max,i-map.get(mod));
                }
                if(!map.containsKey(mod)){
                    map.put(mod,i);
                }

            }
            System.out.println(max);

            T--;
        }
    }
}
