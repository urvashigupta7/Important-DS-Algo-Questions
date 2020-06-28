package graph;

import java.util.Scanner;
import java.util.Stack;

public class FloodFill {
    public static void main(String[] args) {
        Scanner scrn=new Scanner(System.in);
        int m=scrn.nextInt();
        int n=scrn.nextInt();
        int [][]a=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                a[i][j]=scrn.nextInt();
            }
        }
        int []mx={-1,-1,-1,0,1,1,1,0};
        int []my={-1,0,1,1,1,0,-1,-1};
        int s1=scrn.nextInt();
        int s2=scrn.nextInt();
        int c=scrn.nextInt();
        int tobereplaced=a[s1][s2];
        boolean [][]visited=new boolean[m][n];
        Stack<GNode>st=new Stack<>();
        st.push(new GNode(s1,s2));
        visited[s1][s2]=true;
        while(!st.isEmpty()){
            GNode curr=st.pop();
            int currx=curr.x;
            int curry=curr.y;
            a[currx][curry]=c;
            for(int i=0;i<mx.length;i++){
                int newx=currx+mx[i];
                int newy=curry+my[i];
                if(isSafe(newx,newy,m,n)&&!visited[newx][newy]&&a[newx][newy]==tobereplaced){
                    st.push(new GNode(newx,newy));
                    visited[newx][newy]=true;
                }
            }
        }
        for(int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static boolean isSafe(int i,int j,int m,int n){
        if(i>=0&&i<m&&j>=0&&j<n){
            return true;
        }
        return false;
    }
}
class GNode{
    int x;
    int y;
    public GNode(int x,int y){
        this.x=x;
        this.y=y;
    }
}
