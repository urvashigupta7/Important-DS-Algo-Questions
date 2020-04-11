package FenwickTree;

import java.util.Scanner;

public class FT {
    public static void main(String[] args) {
        Scanner scrn=new Scanner(System.in);
        int n=scrn.nextInt();
        int []a=new int[n+1];
        for(int i=1;i<=n;i++){
            a[i]=scrn.nextInt();
        }
        int []bit=new int[n+1];
        for(int i=1;i<=n;i++) {
            update(bit,i,a[i]);
        }
        int q=scrn.nextInt();
        while(q>0){
            int l=scrn.nextInt();
            int r=scrn.nextInt();
            System.out.println(query(bit,r)-query(bit,l-1));
            q--;
        }
    }
    public static void update(int []bit,int index,int inc){
        while(index<=bit.length){
            bit[index]+=inc;
            index+=(index&(-index));
        }
    }
    public static int query(int []bit,int i){
        int sum=0;
        while(i>0){
            sum+=bit[i];
            i-=(i&(-i));
        }
        return sum;
    }
}
