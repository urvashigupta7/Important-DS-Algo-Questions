package hashing;

import java.util.ArrayList;
import java.util.HashMap;

public class PointsonLine {
    public static void main(String[] args) {
        ArrayList<Integer>a=new ArrayList<>();
        ArrayList<Integer>b=new ArrayList<>();
        a.add(0);
        a.add(1);
        a.add(-1);
        b.add(0);
        b.add(1);
        b.add(-1);
        System.out.println(maxPoints(a,b));
    }
    public  static int maxPoints(ArrayList<Integer> a, ArrayList<Integer> b) {
        if(a.size()<2){
            return a.size();
        }
        Pair []p=new Pair[b.size()];
        for(int i=0;i<b.size();i++){
            p[i]=new Pair(a.get(i),b.get(i));
        }
        int maxpoint=Integer.MIN_VALUE;
        HashMap<Pair,Integer> map=new HashMap<>();
        for(int i=0;i<p.length;i++){
            int overlap=0;
            int vertical=0;
            int slopemax=0;
            for(int j=i+1;j<p.length;j++){
                if(p[i]==p[j]){
                    overlap++;
                }else if(p[i].x==p[j].x){
                    vertical++;
                }
                else{
                    int y1=p[j].y-p[i].y;
                    int x1=p[j].x-p[i].x;
                    int calc=gcd(x1,y1);
                    y1=y1/calc;
                    x1=x1/calc;
                    Pair newPair=new Pair(x1,y1);
                    if(!map.containsKey(newPair)){
                        map.put(newPair,1);
                    }else{
                        map.put(newPair,map.get(newPair)+1);
                    }
                    slopemax=Math.max(slopemax,map.get(newPair));
                }
                slopemax=Math.max(slopemax,vertical);
            }
            maxpoint=Math.max(maxpoint,overlap+slopemax+1);
        }
        return maxpoint;
    }
    public static int gcd(int a,int b){
        if(b==0){
            return a;
        }
        return gcd(b,a%b);
    }
}
class Pair{
    int x;
    int y;
    Pair(int x,int y){
        this.x=x;
        this.y=y;
    }
    public int hashCode() {
        return x * 31 + y;
    }
    public boolean equals(Object o){
        Pair other=(Pair)o;
        return (this.x == other.x) && (this.y == other.y);
    }
}

