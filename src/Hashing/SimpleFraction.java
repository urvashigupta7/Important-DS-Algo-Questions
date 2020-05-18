package Hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class SimpleFraction {
    public static void main(String[] args) {
        Scanner scrn=new Scanner(System.in);
        int T=scrn.nextInt();
        while(T>0){
            int N=scrn.nextInt();
            int D=scrn.nextInt();
            HashMap<Integer,Integer>map=new HashMap<>();
            int rem=N%D;
            if(rem==0){
                System.out.println(N/D);
            }else{
                String res=Integer.toString(N/D);
                StringBuilder r= new StringBuilder();
                int i=0;
                while(rem!=0&&!map.containsKey(rem)){
                    map.put(rem,i);
                    rem=rem*10;
                    r.append(Integer.toString(rem / D));
                    rem=rem%D;
                    if(map.containsKey(rem)){
                        break;
                    }
                    i++;
                }
                if(map.containsKey(rem)){
                    r = new StringBuilder(r.substring(0, map.get(rem)) + "(" + r.substring(map.get(rem), i) + ")");
                    System.out.println(res+"."+r);
                }else{
                    System.out.println(res+"."+r);
                }
            }
            T--;
        }
    }
}
