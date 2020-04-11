package FenwickTree;

import java.util.Scanner;

public class InversCount {
    public static void main(String[] args) {
        Scanner scrn=new Scanner(System.in);
        int n=scrn.nextInt();
        int []a=new int[n+1];
        int max=Integer.MIN_VALUE;
        for(int i=1;i<=n;i++){
            a[i]=scrn.nextInt();
             max=Math.max(max,a[i]);
        }
        int []bit=new int[max+1];
        int count=0;
        for(int i=a.length-1;i>0;i--){
            count+=query(bit,a[i]-1);
            update(bit,a[i],1);
        }
        System.out.println(count);
    }
    public static void update(int []bit,int i,int inc){
        while(i<bit.length){
            bit[i]+=inc;
            i+=(i&(-i));
        }
    }
    public static int query(int []bit,int index){
        int sum=0;
        while (index>0){
            sum+=bit[index];
            index-=(index&(-index));
        }
        return sum;
    }
}
