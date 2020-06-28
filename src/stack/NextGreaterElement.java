package stack;

import java.util.Stack;

public class NextGreaterElement {
    public static void main(String[] args) {
        int []a={ 11, 13, 21, 3 };
        Stack<Integer> st=new Stack<>();
        int []ind=new int[a.length];
        for(int i=0;i<a.length;i++){
            if(st.isEmpty()){
                st.push(i);
            }else{
                while(!st.isEmpty()&&a[st.peek()]<a[i]){
                    ind[st.pop()]=i;
                }
                st.push(i);
            }
        }
        while(!st.isEmpty()){
            ind[st.pop()]=-1;
        }
        for(int i=0;i<a.length;i++){
            if(ind[i]==-1){
                System.out.println(a[i]+" -1");
            }else {
                System.out.println(a[i] + " " + a[ind[i]]);
            }
        }
    }
}
