package searching;

public class MedianInTwoSortedArrays {
    public static void main(String[] args) {
        int []m={-43, -25, -18, -15, -10, 9, 39, 40 };
        int []n={-2};
        System.out.println(median(m,n));
    }
    public static double median(int[] a, int[] b){
        if(a.length>b.length){
            return median(b,a);
        }
        int low=0;
        int high=a.length;
        while(low<=high){
            int partitionX=(low+high)/2;
            int partitionY=((a.length+b.length+1)/2)-partitionX;
            int maxLeftX=partitionX==0?Integer.MIN_VALUE:a[partitionX-1];
            int minRightX=partitionX==a.length?Integer.MAX_VALUE:a[partitionX];
            int maxLeftY=partitionY==0?Integer.MIN_VALUE:b[partitionY-1];
            int minRightY=partitionY==b.length?Integer.MAX_VALUE:b[partitionY];
            if(maxLeftX<=minRightY&&maxLeftY<=minRightX){
                if((a.length+b.length)%2==0){
                    return ((double) Math.max(maxLeftX,maxLeftY)+Math.min(minRightX,minRightY))/2;
                }else{
                    return (double) Math.max(maxLeftX,maxLeftY);
                }
            }else if(maxLeftX>minRightY){
                high=partitionX-1;
            }else{
                low=partitionX+1;
            }
        }
        throw new IllegalArgumentException();
    }
}
