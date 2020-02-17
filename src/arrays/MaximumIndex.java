package arrays;

public class MaximumIndex {
    public static void main(String[] args) {
        int arr[] = {9, 2, 3, 4, 5, 6, 7, 8, 18, 0};
        int[] Lmin = new int[arr.length];
        int[] Rmax = new int[arr.length];
        Lmin[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < Lmin[i - 1]) {
                Lmin[i] = arr[i];
            } else {
                Lmin[i] = Lmin[i - 1];
            }
        }
        Rmax[arr.length-1]=arr[arr.length-1];
        for (int i = arr.length-2; i >= 0; i--) {
            if (arr[i] > Rmax[i+1]) {
                Rmax[i] = arr[i];
            } else {
                Rmax[i] = Rmax[i+1];
            }
        }
        int i=0,j=0,maxdiff=-1;
        while(i<arr.length&&j<arr.length){
            if(Lmin[i]<Rmax[j]){
                maxdiff=Math.max(maxdiff,j-i);
                j++;
            }
            else{
                i++;
            }
        }
        System.out.println(maxdiff);
    }
}
