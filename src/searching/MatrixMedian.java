package searching;

import java.util.ArrayList;

public class MatrixMedian {
    public static void main(String[] args) {
        ArrayList<Integer>in1=new ArrayList<>();
        ArrayList<Integer>in2=new ArrayList<>();
        ArrayList<Integer>in3=new ArrayList<>();
        in1.add(1);
        in1.add(3);
        in1.add(5);
        in2.add(2);
        in2.add(6);
        in2.add(9);
        in3.add(3);
        in3.add(6);
        in3.add(9);
        ArrayList<ArrayList<Integer>>al=new ArrayList<>();
        al.add(in1);
        al.add(in2);
        al.add(in3);
        System.out.println(findMedian(al));
    }
    public static int findMedian(ArrayList<ArrayList<Integer>> A) {
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<A.size();i++){
            min=Math.min(min,A.get(i).get(0));
        }
        for(int i=0;i<A.size();i++){
            max=Math.max(max,A.get(i).get(A.get(i).size()-1));
        }
        int desired=(A.get(0).size()*A.size())/2;
        while(min<max){
            int mid=(min+max)/2;
            int getsmaller=0;
            for(int i=0;i<A.size();i++){
                int count=countSmall(A.get(i),mid);
                getsmaller+=count;
            }
            if(getsmaller<desired){
                min=mid+1;
            }else{
                max=mid;
            }
        }
        return  min;

    }
    public static int countSmall(ArrayList<Integer> a, int val){
        int left=0;
        int right=a.size()-1;
        int count=0;
        while(left<=right){
            int mid=(left+right)/2;
            if(a.get(mid)<=val){
                count=mid+1;
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        return count;
    }
}
