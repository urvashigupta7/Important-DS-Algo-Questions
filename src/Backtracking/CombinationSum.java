package Backtracking;

import java.util.*;

public class CombinationSum {
    public static void main(String[] args) {
        Scanner scrn=new Scanner(System.in);
        int T=scrn.nextInt();
        while(T>0){
            int N=scrn.nextInt();
            int []A=new int[N];
            for(int i=0;i<N;i++){
                A[i]=scrn.nextInt();
            }
            Arrays.sort(A);
            int B=scrn.nextInt();
            ArrayList<ArrayList<Integer>>al=new ArrayList<>();
            combination(A,B,al,new ArrayList<>(),0);
            for(int i=0;i<al.size();i++){
                System.out.print("(");
                for(int j=0;j<al.get(i).size()-1;j++){
                    System.out.print(al.get(i).get(j)+" ");
                }
                System.out.print(al.get(i).get(al.get(i).size()-1)+")");
            }
            System.out.println();

            T--;
        }
    }
    public static void combination(int []A,int B,ArrayList<ArrayList<Integer>>ans,ArrayList<Integer>al,int j){
        if(B<0){
            return;
        }
        if(B==0){
            ArrayList<Integer>copy=new ArrayList<>(al);
            ans.add(copy);
            return;
        }

        for(int i=j;i<A.length;i++){
            al.add(A[i]);
            combination(A,B-A[i],ans,al,j);
            j++;
            al.remove(al.size()-1);
        }
    }
}
