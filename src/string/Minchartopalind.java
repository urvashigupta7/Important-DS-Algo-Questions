package string;

import java.util.Arrays;

public class Minchartopalind {
    public static void main(String[] args) {
        String s="AACECAAAA";
        StringBuilder S=new StringBuilder();
        S.append(s);
        String rev=new StringBuilder(s).reverse().toString();
        S.append("$");
        S.append(rev);
        System.out.println(s.length()-func(S.toString()));

    }
    public static int func(String s){
        int []lps=new int [s.length()];
        lps[0]=0;
        int i=1;
        int len=0;
        while(i<s.length()){
            if(s.charAt(i)==s.charAt(len)){
                len++;
                lps[i]=len;
                i++;
            }else{
                if(len!=0){
                    len=lps[len-1];
                }else{
                    lps[i]=0;
                    i++;
                }
            }
        }

        return lps[s.length()-1];
    }
}
