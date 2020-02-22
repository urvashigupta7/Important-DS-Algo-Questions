package string;

public class Power2 {
    public static void main(String[] args) {
        System.out.println(ispower("147573952589676412928"));
    }
    public static int ispower(String a) {

        if(a.length()==1&&(a.charAt(0)-'0')==1){
            return 0;
        }

        while(a.length()!=1||(a.charAt(a.length()-1)-'0')!=1){
            if((a.charAt(a.length()-1)-'0')%2!=0){
                return 0;
            }
            int rem=0;
            StringBuilder sb=new StringBuilder();
            for(int i=0;i<a.length();i++){

                if((a.charAt(i)-'0')<2&&rem==0){
                    if(i!=0) {
                        sb.append(0);
                    }
                    rem+=a.charAt(i)-'0';
                }else {
                    sb.append((rem * 10 +a.charAt(i)-'0')/2);
                    rem=(rem * 10 +a.charAt(i)-'0')%2;
                }
            }
            a=sb.toString();
        }
        return 1;
    }
}
