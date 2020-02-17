import java.util.ArrayList;
import java.util.Arrays;

public class RecursionPractice {
    public static void main(String[] args) {
         printperms("abc","");
         ArrayList<String>res=permutaion("abc");
        System.out.println(res);
        int []a={8,4,2,-3,-8};
        bubbleSort(0,0,a);
        System.out.println(Arrays.toString(a));
        System.out.println(subsequence("abc"));
        System.out.println(getKPC("379"));
    }
    public static void printperms(String ques,String ans){
     if(ques.length()==0){
         System.out.println(ans);
         return;
     }

        char cc=ques.charAt(0);
       String ros=ques.substring(1);
       for(int i=0;i<=ans.length();i++){
           String left=ans.substring(0,i);
           String right=ans.substring(i);
           printperms(ros,left+cc+right);
       }

    }
    public static ArrayList<String> permutaion(String s){
        if(s.length()==0){
            ArrayList<String>base=new ArrayList<>();
            base.add("");
            return base;
        }
        char cc=s.charAt(0);
        String ros=s.substring(1);
        ArrayList<String>recresult=permutaion(ros);
        ArrayList<String>myresult=new ArrayList<>();
        for(int i=0;i<recresult.size();i++){
            String curr=recresult.get(i);
            for(int j=0;j<=curr.length();j++){
                String left=curr.substring(0,j);
                String right=curr.substring(j);
                myresult.add(left+cc+right);
            }
        }
        return myresult;
    }
    public static void bubbleSort(int i,int j,int []a){
        if(j==a.length-1){
            return;
        }
        if(i==a.length-1){
            bubbleSort(0,j+1,a);
            return;
        }
        if(a[i]>a[i+1]){
            int temp=a[i];
            a[i]=a[i+1];
            a[i+1]=temp;
        }
        bubbleSort(i+1,j,a);

    }
    public static ArrayList<String>subsequence(String s){
        if(s.length()==0){
            ArrayList<String>base=new ArrayList<>();
            base.add("");
            return base;
        }
        char cc=s.charAt(0);
        String ros=s.substring(1);
        ArrayList<String>recresult=subsequence(ros);
        ArrayList<String>myresult=new ArrayList<>();
        for(int i=0;i<recresult.size();i++){
            String recstring=recresult.get(i);
            myresult.add(recstring);
            myresult.add(cc+recstring);
        }
        return myresult;
    }
    static String[] codes = {"",".", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuvw", "xyz"};
    public static ArrayList<String> getKPC(String s){
        if(s.length()==0){
            ArrayList<String>base=new ArrayList<>();
            base.add("");
            return base;
        }
        char cc=s.charAt(0);
        int cn=cc-'0';
        String ros=s.substring(1);
        ArrayList<String>recresult=getKPC(ros);
        ArrayList<String>myresult=new ArrayList<>();
        for(int i=0;i<recresult.size();i++){
            String code=codes[cn];
            String recstring=recresult.get(i);
            for(int j=0;j<code.length();j++){
                myresult.add(code.charAt(j)+recstring);
            }
        }
        return myresult;
    }

}
