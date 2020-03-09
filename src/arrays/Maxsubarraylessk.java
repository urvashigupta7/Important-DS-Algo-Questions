package arrays;

import java.util.Scanner;

public class Maxsubarraylessk {
    public static void main(String[] args) {
        Scanner scrn=new Scanner(System.in);
        int N=scrn.nextInt();
        int X=scrn.nextInt();
        int Y=scrn.nextInt();
        int []R=new int[N];
        for(int i=0;i<N;i++){
            R[i]=scrn.nextInt();
        }
        int start=0;
        long maxsum=0;
        long curr_sum=R[0];
        for(int i=1;i<N;i++){
            if(curr_sum<=X){
                maxsum=Math.max(maxsum,curr_sum);
            }
            else{
                while (curr_sum+R[i]>X&&start<i){
                    curr_sum-=R[start];
                    start++;
                }
            }
            curr_sum+=R[i];
        }
        if(curr_sum<=X){
            maxsum=Math.max(maxsum,curr_sum);
        }
        long ans=maxsum;
        for(int i=1;i<Y;i++){
        maxsum=maxsum*2;
        ans+=maxsum;
        }
        System.out.println(ans);
    }
}
