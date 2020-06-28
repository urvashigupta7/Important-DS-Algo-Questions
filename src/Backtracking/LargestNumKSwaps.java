package Backtracking;

import java.util.Scanner;

public class LargestNumKSwaps {
    public static void main(String[] args) {
        Scanner scrn=new Scanner(System.in);
        int T=scrn.nextInt();
        while(T>0){
            int K=scrn.nextInt();
            String s=scrn.next();
            char []S=s.toCharArray();
            Max m=new Max(s);
            find(S,K,m,0);
            System.out.println(m.m);
            T--;
        }
    }
    public static void find(char []s,int k,Max m,int curr){
        if(curr==s.length){
            return;
        }
        if(k==0){
            return;
        }
        char max=s[curr];
        for(int i=curr+1;i<s.length;i++){
            if(max<s[i]){
                max=s[i];
            }
        }
        if(max!=s[curr]){
            k-=1;
        }
        for(int j=curr;j<s.length;j++){
            if(s[j]==max){
                char temp=s[j];
                s[j]=s[curr];
                s[curr]=temp;
                if(String.valueOf(s).compareTo(m.m)>0){
                    m.m=String.valueOf(s);
                }
                find(s,k,m,curr+1);
                temp=s[j];
                s[j]=s[curr];
                s[curr]=temp;
            }
        }
    }
}
class Max{
    String m;
    public Max(String s){
        m=s;
    }
}
