package Hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class LongestSubArraySumK {
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
            int []pre=new int[N];
            pre[0]=A[0];
            for(int i=1;i<N;i++){
                pre[i]=A[i]+pre[i-1];
            }
            HashMap<Integer,Integer> map=new HashMap<>();
            int maxlength=Integer.MIN_VALUE;
            for(int i=0;i<N;i++){
                if(pre[i]==K){
                    maxlength=Math.max(maxlength,i+1);
                }
                if(map.containsKey(pre[i]-K)){
                    maxlength=Math.max(maxlength,i-map.get(pre[i]-K));

                }
                if(!map.containsKey(pre[i])){
                    map.put(pre[i],i);
                }
            }
            if(maxlength==Integer.MIN_VALUE){
                System.out.println(0);
            }else{
                System.out.println(maxlength);
            }

            T--;
        }
    }
}
