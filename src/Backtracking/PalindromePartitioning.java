package Backtracking;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class PalindromePartitioning {
    public static void main(String[] args) {
        String a="efe";
        System.out.println(partition(a));
    }
    public static ArrayList<ArrayList<String>> partition(String a) {
        ArrayList<ArrayList<String>>ans=new ArrayList<>();
        ArrayList<String> currPart = new ArrayList<>();
        solve(a,0,ans,currPart);
        return ans;
    }
    public static void solve(String a,int start,ArrayList<ArrayList<String>>ans,ArrayList<String> curr){
        if(start==a.length()){
            ArrayList<String>copy=new ArrayList<>(curr);
            ans.add(copy);
            return;
        }
        for(int i=start;i<a.length();i++){
            if(isPalindrome(a,start,i)){
                curr.add(a.substring(start,i+1));
                solve(a,i+1,ans,curr);
                curr.remove(curr.size()-1);
            }
        }
    }
    public static boolean isPalindrome(String str,int start,int end){
        while (start < end)
        {
            if (str.charAt(start++) != str.charAt(end--))
                return false;
        }
        return true;
    }
}
