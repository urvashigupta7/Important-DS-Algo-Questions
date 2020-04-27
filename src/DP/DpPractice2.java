package DP;

import java.util.Arrays;

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
        System.out.println(editDistanceI("saturday","sunday"));
        System.out.println(editDistancers("saturday","sunday",new int[9][7]));
        int []a={1, 5, 8, 9, 10, 17, 17, 20};
        System.out.println(rodcutting(a,a.length,new int[a.length+1]));
        System.out.println(rodcut(a,8,a.length));
        int []A={8,7,5,9,6,6,8};
        int []B={1,7,5,1,2,3,9};
        System.out.println(maximumTipCalc(A,B,3,4,0,0,new int[4][5]));
        int []ar={1, 101, 2, 3, 100, 4, 5};
        System.out.println(longestIncSub(ar));
        System.out.println(maxincsubsum(ar));
        int []wt={4,5,1};
        int []val={1 ,2 ,3,};
        System.out.println(Knapsack(wt,val,4,wt.length, new int[wt.length+1][5]));
        String str1="geeksforgeeks";
        System.out.println(longestPalindrSubs(str1,0,str1.length()-1));
        System.out.println(longestPalindrSubsI(str1));
        System.out.println(eggdrop(2,10));
        System.out.println(eggdroprs(2,10,new int[3][11]));
        int []m={1,2,3,4,3};
        System.out.println(mcm(m,1,m.length-1));
        int [][]tdp=new int[m.length+1][m.length+1];
        for(int i=0;i<m.length+1;i++){
            for(int j=0;j<m.length+1;j++){
                tdp[i][j]=-1;
            }
        }
        System.out.println(mcmrs(m,1,m.length-1,tdp));
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
    public static int editDistance(String str1,String str2){
        if(str1.length()==0){
            return str2.length();
        }
        if(str2.length()==0){
            return str1.length();
        }
        char cc1=str1.charAt(0);
        char cc2=str2.charAt(0);
        String ros1= str1.substring(1);
        String ros2=str2.substring(1);
        if(cc1==cc2){
           return editDistance(ros1,ros2);
        }
        else{
            return 1+Math.min(editDistance(ros1,ros2),Math.min(editDistance(str1,ros2),editDistance(ros1,str2)));
        }
    }
    public static int editDistancers(String str1,String str2,int [][]store){
        if(str1.length()==0){
            return str2.length();
        }
        if(str2.length()==0){
            return str1.length();
        }
        char cc1=str1.charAt(0);
        char cc2=str2.charAt(0);
        String ros1= str1.substring(1);
        String ros2=str2.substring(1);
        if(store[str1.length()][str2.length()]!=0){
            return store[str1.length()][str2.length()];
        }
        int rv=0;
        if(cc1==cc2){
            rv= editDistancers(ros1,ros2,store);
            return rv;
        }
        else{
            rv= 1+Math.min(editDistancers(ros1,ros2,store),Math.min(editDistancers(str1,ros2,store)
                    ,editDistancers(ros1,str2,store)));
            return rv;
        }
    }
    public static int editDistanceI(String s1,String s2){
        int [][]store=new int[s1.length()+1][s2.length()+1];
        for(int i=s1.length();i>=0;i--){
            for(int j=s2.length();j>=0;j--){
                if(i==s1.length()) {
                    store[i][j] = s2.length() - j;
                }else if(j==s2.length()){
                    store[i][j]=s1.length()-i;
                }else{
                    if(s1.charAt(i)==s2.charAt(j)){
                        store[i][j]=store[i+1][j+1];
                    }
                    else{
                        int ans1=store[i+1][j+1];
                        int ans2=store[i+1][j];
                        int ans3=store[i][j+1];
                        store[i][j]=1+Math.min(ans1,Math.min(ans2,ans3));
                    }
                }
            }
        }
        return store[0][0];
    }
    public static int rodcutting(int []a,int n,int []store){
        if(n==0){
           return 0;
        }
        if(n<0){
            return 0;
        }
        if(store[n]!=0){
            return store[n];
        }
        int ans=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            ans=Math.max(ans,a[i]+rodcutting(a,n-i-1,store));
        }
        store[n]= ans;
        return ans;
    }
    public static int rodcut(int []a,int t,int n){
        if(n==0||t==0){
            return 0;
        }
        if(n>t){
            return rodcut(a,t,n-1);
        }
        return Math.max(rodcut(a,t,n-1),a[n-1]+rodcut(a,t-n,n-1));

    }
    public static int maximumTipCalc(int []A,int []B,int x,int y,int count1,int count2,int [][]store){
        if(count1==x){
            int sum=0;
            for (int k=(count1+count2);k<B.length;k++){
                sum+=B[k];
            }
            return sum;
        }
        if(count2==y){
            int sum=0;
            for (int k=(count1+count2);k<A.length;k++){
                sum+=A[k];
            }
            return sum;
        }
        if(count1+count2>=A.length){
            return 0;
        }
        if(store[count1][count2]!=0){
            return store[count1][count2];
        }

        int ans= Math.max(A[count1+count2]+maximumTipCalc(A,B,x,y,count1+1,count2,store),
                B[count1+count2]+maximumTipCalc(A,B,x,y,count1,count2+1,store));
       store[count1][count2]=ans;
       return ans;

    }
    public static int longestIncSub(int []a){
        int []lis=new int[a.length];
        Arrays.fill(lis,1);
        for(int i=1;i<a.length;i++){
            for(int j=0;j<i;j++){
                if(a[i]>a[j]){
                    lis[i]=Math.max(lis[j]+1,lis[i]);
                }
            }
        }
        int max=Integer.MIN_VALUE;
        for(int i=0;i<lis.length;i++){
            max=Math.max(max,lis[i]);
        }
        return max;
    }
    public static int maxincsubsum(int []a){
        int []maxsum=new int[a.length];
        for(int i=0;i<a.length;i++){
            maxsum[i]=a[i];
        }
        for(int i=1;i<a.length;i++){
            for(int j=0;j<i;j++){
                if(a[i]>a[j]){
                    maxsum[i]=Math.max(maxsum[i],a[i]+maxsum[j]);
                }
            }
        }
        int max=Integer.MIN_VALUE;
        for(int i=0;i<maxsum.length;i++){
            max=Math.max(max,maxsum[i]);
        }
        return max;
    }
    public static int Knapsack(int []wt,int []val,int w,int n,int [][]store){
        if(n==0||w==0){
            return 0;
        }
        if(wt[n-1]>w){
            return Knapsack(wt,val,w,n-1,store);
        }
        if(store[n][w]!=0){
            return store[n][w];
        }
        int ans= Math.max(Knapsack(wt,val,w,n-1,store),val[n-1]+Knapsack(wt,val,w-wt[n-1],n-1,store));
        store[n][w]=ans;
        return ans;
    }
    public static int longestPalindrSubs(String str1,int i,int j){
        if(i==j){
            return 1;
        }
        if((i+1==j)&&str1.charAt(i)==str1.charAt(j)){
            return 2;
        }
        if(str1.charAt(i)==str1.charAt(j)){
            return longestPalindrSubs(str1,i+1,j-1)+2;
        }
        else{
            return Math.max(longestPalindrSubs(str1,i+1,j),longestPalindrSubs(str1,i,j-1));
        }
    }
    public static  int longestPalindrSubsI(String str1){
        int [][]store=new int[str1.length()][str1.length()];
        for(int i=0;i<str1.length();i++){
            store[i][i]=1;
        }
        for(int l=2;l<= str1.length();l++){
            for(int i=0;i<str1.length()-l+1;i++){
                int j=i+l-1;
                if (str1.charAt(i) == str1.charAt(j) && l == 2)
                    store[i][j] = 2;
                else if (str1.charAt(i) == str1.charAt(j))
                    store[i][j] = store[i+1][j-1] + 2;
                else
                    store[i][j] = Math.max(store[i][j-1], store[i+1][j]);
            }
        }
        return store[0][str1.length()-1];
    }
    public static int eggdrop(int n,int k){
        if(k==0||k==1){
            return 1;
        }
        if(n==1){
            return k;
        }
        int min=Integer.MAX_VALUE;
        for(int i=1;i<=k;i++){
            min=Math.min(min,Math.max(eggdrop(n-1,i-1),eggdrop(n,k-i))+1);
        }
        return min;
    }
    public static int eggdroprs(int n,int k,int [][]store){
        if(k==0||k==1){
            return 1;
        }
        if(n==1){
            return k;
        }
        if(store[n][k]!=0){
            return store[n][k];
        }
        int ans=Integer.MAX_VALUE;
        for(int i=1;i<=k;i++){
           ans=Math.min(ans,Math.max(eggdroprs(n-1,i-1,store),eggdroprs(n,k-i,store))+1);
        }
        store[n][k]=ans;
        return ans;
    }
    public static int mcm(int []m,int i,int j){
        if(i==j){
            return 0;
        }
        int ans=Integer.MAX_VALUE;
        for(int k=i;k<j;k++){
            ans=Math.min(ans,mcm(m,i,k)+mcm(m,k+1,j)+m[i-1]*m[k]*m[j]);
        }
        return ans;
    }
    public static int mcmrs(int []m,int i,int j,int[][]tdp){
        if(i==j){
            return 0;
        }
        int ans=Integer.MAX_VALUE;
        if(tdp[i][j]!=-1){
            return tdp[i][j];
        }
        for(int k=i;k<j;k++){
            ans=Math.min(ans,mcm(m,i,k)+mcm(m,k+1,j)+m[i-1]*m[k]*m[j]);
        }
        tdp[i][j]=ans;
        return tdp[i][j];
    }
}
