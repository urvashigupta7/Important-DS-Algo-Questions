package Greedy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class Nmeeting {
    public static void main(String[] args) {
        Scanner scrn=new Scanner(System.in);
        int T=scrn.nextInt();
        while(T>0){
            int N=scrn.nextInt();
            int []S=new int[N];
            int []F=new int[N];
            for(int i=0;i<N;i++){
                S[i]=scrn.nextInt();
            }
            for(int i=0;i<N;i++){
                F[i]=scrn.nextInt();
            }
            ArrayList<Meeting>al=new ArrayList<>();
            for(int i=0;i<N;i++){
                al.add(new Meeting(S[i],F[i],i));
            }
            Collections.sort(al);
            ArrayList<Integer>ans=new ArrayList<>();
            ans.add(al.get(0).index+1);
            int end=al.get(0).end;
            for(int i=1;i<N;i++){
              if(al.get(i).start>end){
                  ans.add(al.get(i).index+1);
                  end=al.get(i).end;
              }
            }
            for(int i=0;i<ans.size();i++){
                System.out.print(ans.get(i)+" ");
            }
            System.out.println();
            T--;
        }
    }
}
class Meeting implements Comparable<Meeting>{
    int start;
    int end;
    int index;
    public Meeting(int s,int e,int i){
        start=s;
        end=e;
        index=i;
    }

    @Override
    public int compareTo(Meeting meeting) {
        return this.end-meeting.end;
    }
}
