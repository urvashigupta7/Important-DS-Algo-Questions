package Backtracking;

import java.util.*;
import java.lang.*;

class HamiltonianPath {
	public static void main (String[] args) {
	    Scanner scrn=new Scanner(System.in);
	    int T=scrn.nextInt();
		while(T>0){
		    int N=scrn.nextInt();
		    int M=scrn.nextInt();
		    ArrayList<ArrayList<Integer>>al=new ArrayList<>();
		    for(int i=0;i<N;i++){
		        al.add(new ArrayList<>());
		    }
		    for(int i=0;i<M;i++){
		        int u=scrn.nextInt();
		        int v=scrn.nextInt();
		        al.get(u-1).add(v-1);
		        al.get(v-1).add(u-1);
		    }
		    System.out.println(solve(al,N));
		    T--;
		}
	}
	public  static int  solve(ArrayList<ArrayList<Integer>>al,int n){
	    for(int i=0;i<n;i++){
	        if(ishamiltonian(al,i,1<<i,(1<<n)-1)){
	            return 1;
	        }
	    }
	    return 0;
	}
	public static boolean ishamiltonian(ArrayList<ArrayList<Integer>>al,int pos,int mask,int visited){
	    if(mask==visited){
	        return true;
	    }
	    ArrayList<Integer>nbrs=al.get(pos);
	    for(Integer nbr:nbrs){
	        if((mask&(1<<nbr))==0){
	           if(ishamiltonian(al,nbr,mask|1<<nbr,visited)){
	               return true;
	           }
	        }
	    }
	    return false;
	}
}