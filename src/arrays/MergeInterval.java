package arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Stack;

public class MergeInterval {
    public static void main(String[] args) {
        Interval i1=new Interval(1,3);
        Interval i2=new Interval(2,6);
        Interval i3=new Interval(8,10);
        Interval i4=new Interval(15,18);
        ArrayList<Interval>al=new ArrayList<>();
        al.add(i1);
        al.add(i2);
        al.add(i3);
        al.add(i4);
        al=merge(al);
        for(int i=0;i<al.size();i++){
            System.out.println(al.get(i).start+" "+al.get(i).end);
        }
    }
    public static ArrayList<Interval>merge(ArrayList<Interval>intervals){
        Collections.sort(intervals);
        Stack<Interval>st=new Stack<>();
        st.push(intervals.get(0));
        for(int i=1;i<intervals.size();i++){
            Interval top=st.peek();
            if(intervals.get(i).start>top.end){
                st.push(intervals.get(i));
            }else if(intervals.get(i).end>top.end){
                top=st.pop();
                top.end=intervals.get(i).end;
                st.push(top);
            }
        }
        ArrayList<Interval>ans=new ArrayList<>();
        while (!st.isEmpty()){
            ans.add(st.pop());
        }
        Collections.sort(ans);
        return ans;
    }
    static class Interval implements Comparable<Interval> {
        int start;
        int end;
        public Interval(int s,int e){
            this.start=s;
            this.end=e;
        }

        @Override
        public int compareTo(Interval interval) {
            return this.start-interval.start;
        }
    }
}

