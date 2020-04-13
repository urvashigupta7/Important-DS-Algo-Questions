package DP;

import java.util.Arrays;

public class DpPractice {
    public static void main(String[] args) {
        int n=10;
        System.out.println(fibrs(new int[n+1],n));
        int []store=new int[n+1];
        Arrays.fill(store,-1);
        System.out.println(cbp(0,10));
        System.out.println(cbprs(store,0,10));
        System.out.println(cbpi(0,10));
        String str1="bd";
        String str2="abcd";
        System.out.println(lcs(str1,str2));
        int [][]lcsStore=new int[str1.length()+1][str2.length()+1];
        System.out.println(lcsrs(lcsStore,str1,str2));
        System.out.println(lcsi(str1,str2));
    }
    public static int fibrs(int []str,int n){
        if(n==0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        if(str[n]!=0){
            return str[n];
        }
        int ans=fibrs(str,n-1)+fibrs(str,n-2);
        str[n]=ans;
        return ans;
    }
    public static int cbp(int st,int en){
        if(st>en){
            return 0;
        }
        if(st==en){
            return 1;
        }
        int totalways=0;
        for(int i=1;i<=6;i++){
            totalways+=cbp(st+i,en);
        }
        return totalways;
    }
    public static int cbprs(int []store,int st,int en){
        if(st>en){
            return 0;
        }
        if(st==en){
            return 1;
        }
        if(store[st]!=-1){
            return store[st];
        }
        int totalways=0;
        for(int i=1;i<=6;i++){
            totalways+=cbp(st+i,en);
        }
        store[st]=totalways;
        return totalways;

    }
    public static int cbpi(int st,int en){
        int []store=new int[en+1];
        store[en]=1;
        for(int i=en-1;i>=0;i--){
            int totalways=0;
            for(int j=1;j<=6&&(i+j)<store.length;j++){
                totalways+=store[i+j];
            }
            store[i]=totalways;
        }
        return store[0];
    }
    public static int lcs(String str1,String str2){
        if(str1.length()==0||str2.length()==0){
            return 0;
        }
        char cc1=str1.charAt(0);
        char cc2= str1.charAt(0);
        String ros1=str1.substring(1);
        String ros2=str2.substring(1);
        if(cc1==cc2){
            return 1+lcs(ros1,ros2);
        }else{
            return Math.max(lcs(str1,ros2),lcs(ros1,str2));
        }
    }
    public static int lcsrs(int [][]store,String str1,String str2){
        if(str1.length()==0||str2.length()==0){
            return 0;
        }
        if(store[str1.length()][str2.length()]!=0){
            return store[str1.length()][str2.length()];
        }
        char cc1=str1.charAt(0);
        char cc2= str1.charAt(0);
        String ros1=str1.substring(1);
        String ros2=str2.substring(1);

        if(cc1==cc2){
            int rv= 1+lcsrs(store,ros1,ros2);
            store[str1.length()][str2.length()]=rv;
            return rv;
        }else{
            int rv=Math.max(lcsrs(store,str1,ros2),lcsrs(store,ros1,str2));
            store[str1.length()][str2.length()]=rv;
            return rv;
        }
    }
    public static int lcsi(String str1,String str2){
        int [][]lcsStore=new int[str1.length()+1][str2.length()+1];
        for(int i=str1.length()-1;i>=0;i--){
            for(int j=str2.length()-1;j>=0;j--){
                if(str1.charAt(i)== str2.charAt(j)){
                    lcsStore[i][j]=1+lcsStore[i+1][j+1];
                }else{
                    lcsStore[i][j]=Math.max(lcsStore[i+1][j],lcsStore[i][j+1]);
                }
            }
        }
        return lcsStore[0][0];
    }
}
