package DP;

public class DpPractice2 {
    public static void main(String[] args) {
        char digits[] = {'1', '2', '3', '4'};
        int n = digits.length;
        int []store=new int[n+1];
        System.out.println(count(digits, n,store));
        int cost[][] = { {1, 2, 3},
                {4, 8, 2},
                {1, 5, 3} };
        int [][]st=new int[cost.length][cost[0].length];
        System.out.println(minCostPath(cost,0,0,st));
        int arr[] = {1, 2, 3};
        System.out.println(CoinChange(arr, arr.length,4,new int[arr.length+1][5]));

    }
    public  static  int count(char []d,int n,int []store){
        if(n==0||n==1){
            return 1;
        }
        if(d[0]=='0'){
            return 0;
        }
        int count=0;
        if(store[n]!=0){
            return store[n];
        }
        if(d[n-1]>'0'){
            count=count(d,n-1,store);
        }
        if(d[n-2]=='1'||d[n-1]<'7'&&d[n-2]=='2'){
            count+=count(d,n-2,store);
        }
        store[n]=count;
        return count;
    }
    public static int minCostPath(int[][]a,int i,int j,int [][]store){
        if(i>=a.length||j>=a[0].length){
            return Integer.MAX_VALUE;
        }
        if(i==a.length-1&&j==a[0].length-1){
            return a[i][j];
        }
        if(store[i][j]!=0){
            return store[i][j];
        }
        int ans=a[i][j]+Math.min(minCostPath(a,i+1,j+1,store),Math.min(minCostPath(a,i+1,j,store),
                minCostPath(a,i,j+1,store)));
        store[i][j]=ans;
        return ans;
    }
    public static int CoinChange(int []coin,int n,int val,int [][]store){
        if(val==0){
            return 1;
        }
        if(val<0){
            return 0;
        }
        if(n<=0&&val>0){
            return 0;
        }
        if(store[n][val]!=0){
            return store[n][val];
        }
        int ans= CoinChange(coin,n-1,val,store)+CoinChange(coin,n,val-coin[n-1],store);
        store[n][val]=ans;
        return ans;
    }
}
