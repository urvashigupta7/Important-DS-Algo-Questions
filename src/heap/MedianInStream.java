package heap;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MedianInStream {
    public static void main(String[] args) {
        PriorityQueue<Integer>minHeap=new PriorityQueue<>();
        PriorityQueue<Integer>maxHeap=new PriorityQueue<>(Collections.reverseOrder());
        Scanner scrn=new Scanner(System.in);
        int N=scrn.nextInt();
        while(N>0){

            if(minHeap.size()==0&&maxHeap.size()==0){
                maxHeap.offer(scrn.nextInt());
                System.out.println(maxHeap.peek());
            }else{
                int val=scrn.nextInt();
                if(val<=maxHeap.peek()){
                    maxHeap.offer(val);
                }else{
                    minHeap.offer(val);
                }
                if(Math.abs(minHeap.size()-maxHeap.size())>1){
                    if(minHeap.size()>maxHeap.size()){
                        maxHeap.offer(minHeap.poll());
                    }else{
                        minHeap.offer(maxHeap.poll());
                    }
                }
                if(minHeap.size()==maxHeap.size()){
                    System.out.println((minHeap.peek()+maxHeap.peek())/2);
                }else{
                    if(maxHeap.size()>minHeap.size()){
                        System.out.println(maxHeap.peek());
                    }else{
                        System.out.println(minHeap.peek());
                    }
                }
            }

            N--;
        }
    }
}
