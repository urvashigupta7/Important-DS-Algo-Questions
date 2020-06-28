package searching;

import java.util.ArrayList;

public class PaintersPartition {
    public static void main(String[] args) {
      int A=1;
      int B=1000000;
      ArrayList<Integer>c=new ArrayList<>();
      c.add(1000000);
      c.add(1000000);
    }
    public static int paint(int A, int B, ArrayList<Integer> C) {
        int start=0;
        int end=0;
        int totalsum=0;
        for(int i=0;i<C.size();i++)
        {
            totalsum+=C.get(i);
        }
        int finalanswer=Integer.MAX_VALUE;
        end=totalsum;
        while(start<=end)
        {

            int mid=(start+end)/2;
            if(isPossible(C,A,mid))
            {
                finalanswer=Math.min(finalanswer,mid);
                end=mid-1;
            }
            else
            {
                start=mid+1;
            }
        }
        long ans=finalanswer*B;
        ans=ans%10000003;
        return (int)ans;
    }
    public static boolean isPossible(ArrayList<Integer>a,int n,int currval){
        int painterRequired=1;
        int sum=0;
        for(int i=0;i<a.size();i++){
            if(a.get(i)>currval){
                return false;
            }
            if(sum+a.get(i)>currval){
                painterRequired++;
                sum=a.get(i);
                if(painterRequired>n){
                    return false;
                }
            }else{
                sum+=a.get(i);
            }
        }
        return true;
    }
}
