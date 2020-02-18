package arrays;

import java.util.HashSet;

public class LongestconsecSubs {
    public static void main(String[] args) {
        int []arr={1, 9, 3, 10, 4, 20, 2};
        HashSet<Integer>s=new HashSet<>();
        for(int i=0;i<arr.length;i++){
            s.add(arr[i]);
        }
       int ans=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            if(!s.contains(arr[i]-1)){
                int start=arr[i];
                while(s.contains(start)){
                    start++;
                }
                if(ans<start-arr[i]){
                    ans=start-arr[i];
                }
            }
        }
        System.out.println(ans);
    }
}
