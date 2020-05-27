package DP;

import java.util.Arrays;

public class MinJump {
    public static void main(String[] args) {
        int []a={2,3,0,1,4};
        System.out.println(jump(a));
    }
    public static int jump(int[] A) {
        int ans =jumpdprs(A,0,new int[A.length]);
        if(ans==Integer.MAX_VALUE){
            return -1;
        }else{
            return ans;
        }
    }
    public static int jumpdprs(int []A,int i,int []dp){
        if(i==A.length-1){
            return 0;
        }
        if(i>=A.length){
            return Integer.MAX_VALUE;
        }
        if(A[i]==0){
            return Integer.MAX_VALUE;
        }
        if(dp[i]!=0){
            return dp[i];
        }
        int ans=Integer.MAX_VALUE;
        for(int j=1;j<=A[i];j++){
            int rv=jumpdprs(A,i+j,dp);
            if(rv!=Integer.MAX_VALUE){
                ans=Math.min(ans,1+rv);
            }
        }
        dp[i]=ans;
        return ans;
    }
    public  static int jumpdpi(int[] A) {
        int []dp=new int[A.length];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;
        for(int i=0;i<A.length;i++){
            if(dp[i]!=Integer.MAX_VALUE){
                for(int j=1;j<=A[i];j++){
                    if(i+j<A.length){
                        dp[i+j]=Math.min(dp[i+j],dp[i]+1);
                    }
                }
            }
        }
        if(dp[A.length-1]==Integer.MAX_VALUE){
            return -1;
        }
        return dp[A.length-1];
    }
}
