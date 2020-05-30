package searching;

public class SortedAndRotated {
    public static void main(String[] args) {
        int []a={5,1,3};
        System.out.println(search(a,0,a.length-1,0));
        System.out.println(searchitr(a,0,a.length-1,0));
    }
    static int search(int arr[], int l, int h, int key)
    {
        if (l > h)
            return -1;

        int mid = (l+h)/2;
        if (arr[mid] == key)
            return mid;

        if (arr[l] <= arr[mid])
        {
            if (key >= arr[l] && key <= arr[mid])
                return search(arr, l, mid-1, key);
            return search(arr, mid+1, h, key);
        }
        if (key >= arr[mid] && key <= arr[h])
            return search(arr, mid+1, h, key);

        return search(arr, l, mid-1, key);
    }
    public static int searchitr(int []arr,int l,int h,int key){
        int ans=-1;
        while(l<=h){
            int mid=(l+h)/2;
            if(arr[mid]==key){
                ans=mid;
                break;
            }
            if(arr[l]<=arr[mid]){
                if(key>=arr[l]&&key<=arr[mid]){
                    h=mid-1;
                }
                else{
                    l=mid+1;
                }
            }
            if (key >= arr[mid] && key <= arr[h]){
                l=mid+1;
            }else{
                h=mid-1;
            }
        }
        return ans;
    }

}
