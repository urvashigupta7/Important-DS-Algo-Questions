package Searching;

public class PeakElement {
    public static void main(String[] args) {
        int []a={1, 3, 20, 4, 1, 0};
        System.out.println(peak(a,0,a.length-1));
    }
    public static int peak(int[]a,int l,int r){
        int mid=(l+r)/2;
        if((mid==0||a[mid-1]<=a[mid])&&(mid==a.length-1||a[mid]>=a[mid+1])){
            return mid;
        }else if(a[mid-1]>a[mid]){
            return peak(a,l,r-1);
        }
        else{
            return peak(a,l+1,r);
        }
    }
}
