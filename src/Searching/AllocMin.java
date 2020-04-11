package Searching;

import java.util.Scanner;

public class AllocMin {
    public static void main(String[] args) {
        Scanner scrn=new Scanner(System.in);
        int T=scrn.nextInt();
        while(T>0){
            int N=scrn.nextInt();
            int []a=new int[N];
            for(int i=0;i<N;i++){
                a[i]=scrn.nextInt();
            }
            int M=scrn.nextInt();
            System.out.println(findpages(a,M));


            T--;
        }
    }
    public static int findpages(int []a,int m){
        if (a.length < m)
            return -1;
        int totalsum=0;
        for(int i=0;i<a.length;i++){
            totalsum+=a[i];
        }
        int l=0;
        int r=totalsum;
        int result=Integer.MAX_VALUE;
        while (l<=r){
            int mid=(l+r)/2;
            if(isPossible(a,m,mid)){
                result=Math.min(result,mid);
                r=mid-1;
            }else{
                l=mid+1;
            }
        }
        return result;
    }
    public static boolean isPossible(int []a,int m,int curr_min){
        int currsum=0;
        int required_student=1;
        for(int i=0;i<a.length;i++){
            if(a[i]>curr_min){
                return false;
            }
            if(currsum+a[i]>curr_min){
                required_student++;
                currsum=a[i];
                if(required_student>m){
                    return false;
                }
            }
            else{
                currsum+=a[i];
            }
        }
        return true;
    }
}
