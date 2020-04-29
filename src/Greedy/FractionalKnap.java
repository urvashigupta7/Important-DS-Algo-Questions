package Greedy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class FractionalKnap {
    public static void main(String[] args) {
        int []wt={10, 20};
        int []val={60,100};
        int capacity = 50;
        ArrayList<Item>al=new ArrayList<>();
        for(int i=0;i<wt.length;i++){
            al.add(new Item(wt[i],val[i]));
        }
        Collections.sort(al);
        double totalvalue = 0;
        for(int i=0;i<al.size();i++){
            Item item=al.get(i);
            if(capacity-item.wt>=0){
                totalvalue+=item.val;
                capacity-=item.wt;
            }else{
                double fraction=(double)capacity/(double)item.wt;
                totalvalue+=(item.val*fraction);
                capacity=capacity-(int)(item.wt*fraction);
                break;
            }
        }
        System.out.println(totalvalue);

    }
}
class Item implements Comparable<Item>{
    int wt;
    int val;
    Double cost;
    public Item(int wt,int val){
        this.wt=wt;
        this.val=val;
        cost=(double)val/(double) wt;
    }

    @Override
    public int compareTo(Item item) {
        return item.cost.compareTo(this.cost);
    }
}
