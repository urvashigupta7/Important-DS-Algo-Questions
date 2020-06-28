package greedy;

import java.util.Arrays;

public class MinCashFlow {
    public static void main(String[] args) {
        int g[][] = {{0, 1000, 2000},
                {0, 0, 5000},
                {0, 0, 0},};
        mincashflow(g);
    }

    public static void mincashflow(int [][]g){
        int []amount=new int[g.length];
        for(int i=0;i<g.length;i++){
            for(int j=0;j<g[0].length;j++){
               amount[i]=amount[i]+(g[j][i]-g[i][j]);
            }
        }
        util(amount);
    }
    public static void util(int []amount){
        int mxcredit=getMax(amount);
        int mxdebit=getMin(amount);
        if(amount[mxcredit]==0&&amount[mxdebit]==0){
            return;
        }
        int min=Math.min(-amount[mxdebit],amount[mxcredit]);
        amount[mxcredit]-=min;
        amount[mxdebit]+=min;
        System.out.println("Person "+mxdebit+"pays "+min+" to "+mxcredit);
        util(amount);
    }
    private static int getMax(int []amount){
        int i=0;
        for(int j=1;j<amount.length;j++){
            if(amount[j]>amount[i]){
                i=j;
            }
        }
        return i;
    }
    private static int getMin(int []amount){
        int i=0;
        for(int j=1;j<amount.length;j++){
            if(amount[j]<amount[i]){
                i=j;
            }
        }
        return i;
    }
}
