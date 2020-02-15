import java.util.ArrayList;

public class RecursionPractice {
    public static void main(String[] args) {
         printperms("abc","");
         ArrayList<String>res=permutaion("abc");
        System.out.println(res);
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
}
