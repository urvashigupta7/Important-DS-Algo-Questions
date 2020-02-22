package string;

public class MultiplyTwoStrings {
    public static void main(String[] args) {
        System.out.println(multiply("99999", "99999"));
    }

    public static String multiply(String A, String B) {
        if(A.equals("0")||B.equals("0")){
            return "0";
        }
        int rounds = Math.min(A.length(), B.length());
        if (B.length() > A.length()) {
            String temp = A;
            A = B;
            B = temp;
        }

        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < rounds; i++) {
            long carry = 0;
            StringBuilder sb = new StringBuilder();
            for (int j = A.length() - 1; j >= 0; j--) {
                int lastdigitA = A.charAt(j) - '0';
                int lastdigitB = B.charAt(B.length() - 1 - i) - '0';
                long dig = (lastdigitA * lastdigitB) + carry;
                sb.append(dig % 10);
                carry = dig / 10;
            }
            if (carry > 0) {
                sb.append(carry);
            }
            sb.reverse();
            for (int k = 0; k < i; k++) {
                sb.append(0);
            }
            if (ans.length() != 0) {
                ans = add(sb, ans);
            } else {
                ans = sb;
            }
        }
        int i = 0;
        while (i < ans.length() && ans.charAt(i) == '0')
            i++;
        ans.replace(0, i, "");
        return ans.toString();

}

    public static StringBuilder add(StringBuilder sb, StringBuilder a) {
        StringBuilder ans = new StringBuilder();
        int j = sb.length() - 1;
        int i = a.length() - 1;
        int carry = 0;
        while (j >= 0 || i >= 0) {
            int add = 0;
            add += (j >= 0) ? sb.charAt(j) - '0' : 0;
            add += (i >= 0) ? a.charAt(i) - '0' : 0;
            add += carry;
            ans.append(add % 10);
            carry = add / 10;
            j--;
            i--;
        }
        if (carry > 0) {
            ans.append(carry);
        }
        ans.reverse();
        return ans;
    }

}
