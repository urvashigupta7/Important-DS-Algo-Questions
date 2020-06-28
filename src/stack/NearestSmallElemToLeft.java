package stack;

import java.util.Stack;

public class NearestSmallElemToLeft {
    public static void main(String[] args) {
        int []arr = {1, 3, 0, 2, 5};
        Stack<Integer>st=new Stack<>();
        int []ind=new int[arr.length];
        for(int i=arr.length-1;i>=0;i--){
            if(st.isEmpty()||arr[i]>arr[st.peek()]){
                st.push(i);
            }else{
                while(!st.isEmpty()&&arr[i]<arr[st.peek()]){
                    ind[st.peek()]=i;
                    st.pop();
                }
                st.push(i);
            }
        }
        while(!st.isEmpty()){
            ind[st.peek()]=-1;
            st.pop();
        }
        for(int i=0;i<arr.length;i++){
            if(ind[i]==-1){
                System.out.println(arr[i]+" -1");
            }else {
                System.out.println(arr[i] + " " + arr[ind[i]]);
            }
        }
    }
}
