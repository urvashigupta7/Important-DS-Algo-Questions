package arrays;

import java.util.Arrays;

public class Sorting {
    public static void main(String[] args) {
        int[] a = {-6, 8, 2, 3, -8};
        heapsort(a);
        System.out.println(Arrays.toString(a));
    }

    public static void bubbleSort(int[] a) {
        for (int round = 0; round < a.length - 1; round++) {
            for (int i = 0; i < a.length - 1 - round; i++) {
                if (a[i] > a[i + 1]) {
                    int temp = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = temp;
                }
            }
        }
    }

    public static void insertionSort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i + 1; j > 0 && a[j - 1] > a[j]; j--) {
                int temp = a[j];
                a[j] = a[j - 1];
                a[j - 1] = temp;
            }
        }
    }

    public static void selectionSort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int minind = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[minind]) {
                    minind = j;
                }
            }
            int temp = a[minind];
            a[minind] = a[i];
            a[i] = temp;
        }
    }

    public static int[] mergeSort(int[] a, int l, int r) {
        if (l == r) {
            int[] basearray = new int[1];
            basearray[0] = a[l];
            return basearray;
        }
        int mid = (l + r) / 2;
        int[] lh = mergeSort(a, l, mid);
        int[] rh = mergeSort(a, mid + 1, r);
        int[] res = merge(lh, rh);
        return res;
    }

    public static int[] merge(int[] one, int[] two) {
        int[] res = new int[one.length + two.length];
        int i = 0, j = 0, k = 0;
        while (i < one.length && j < two.length) {
            if (one[i] > two[j]) {
                res[k] = two[j];
                j++;
                k++;
            } else {
                res[k] = one[i];
                i++;
                k++;
            }
        }
        while (i < one.length) {
            res[k] = one[i];
            i++;
            k++;
        }
        while (j < two.length) {
            res[k] = two[j];
            j++;
            k++;
        }
        return res;
    }
    public static void quicksort(int []a,int l,int r){
        if(l>r){
            return;
        }
        int p=partition(a,l,r);
        quicksort(a,l,p-1);
        quicksort(a,p+1,r);
    }
    public static int partition(int []a,int l,int r){
        int in=l-1;
        int pivot=a[r];
        for(int i=l;i<r;i++){
            if(a[i]<=pivot){
                in++;
                int temp=a[in];
                a[in]=a[i];
                a[i]=temp;
            }
        }
        int temp=a[in+1];
        a[in+1]=a[r];
        a[r]=temp;
        return in+1;
    }
    public static void heapsort(int []arr){

        for(int i=arr.length/2-1;i>=0;i--){
            heapify(arr,arr.length,i);
        }
        for(int i=arr.length-1;i>0;i--){
            int temp=arr[0];
            arr[0]=arr[i];
            arr[i]=temp;
            heapify(arr,i,0);
        }
    }
    public static void heapify(int []arr,int n,int i){
        int largest=i;
        int left=2*i+1;
        int right=2*i+2;
        if(left<n&&arr[largest]<arr[left]){
            largest=left;
        }
        if(right<n&&arr[largest]<arr[right]){
            largest=right;
        }
        if(largest!=i){
            int temp=arr[i];
            arr[i]=arr[largest];
            arr[largest]=temp;
            heapify(arr,n,largest);
        }
    }
}

