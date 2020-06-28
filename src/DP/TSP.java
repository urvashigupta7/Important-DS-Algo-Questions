package DP;

import java.util.Arrays;

public class TSP {
    public static int VISITED=(1<<4)-1;
    public static void main(String[] args) {
        int [][]a={
                {0,20,42,25},
                {20,0,30,34},
                {42,30,0,10},
                {25,34,10,0}
        };
        int [][]dp=new int[1<<4][4];
        for(int i=0;i<(1<<4);i++){
            for(int j=0;j<4;j++){
                dp[i][j]=-1;
            }
        }
        System.out.println(VISITED);
        System.out.println(tsp(1,0,a,dp));
    }
    public static int tsp(int mask,int pos,int [][]a,int [][]dp){
        if(VISITED==mask){
            return a[pos][0];
        }
        if(dp[mask][pos]!=-1){
            return dp[mask][pos];
        }
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<a.length;i++){
            if((mask&(1<<i))==0){
                ans=Math.min(ans,a[pos][i]+tsp(mask|(1<<i),i,a,dp));
            }
        }
        dp[mask][pos]=ans;
        return ans;
    }
}
