package string;

public class addtwobinstr {
    public static void main(String[] args) {
        String a = "1101", b="100";
        System.out.println(addBinary(a,b));
    }
    public static String addBinary(String A, String B) {
       StringBuilder ans=new StringBuilder();
       int carry=0;
       int i=A.length()-1;
       int j=B.length()-1;
       while(i>=0||j>=0){
           int digit1=i>=0 ?(A.charAt(i)-'0') : 0;
           int digit2=j>=0 ?(B.charAt(j)-'0') : 0;
           ans.append((digit1+digit2+carry)%2);
           if((digit1+digit2+carry)>1){
               carry=1;
           }else{
               carry=0;
           }
           i--;
           j--;

       }
       if(carry==1){
           ans.append(carry);
       }
       ans.reverse();
       return ans.toString();

    }
}
