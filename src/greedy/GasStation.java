package greedy;

public class GasStation {
    public static void main(String[] args) {
        int[] petrol = {4, 6, 6, 5};
        int[] distance = {7, 3, 4, 5};
        System.out.println(solve(petrol, distance));
    }
    public static int solve(int []petrol,int[] distance){
        int start=0;
        int end=1;
        int curr=petrol[0]-distance[0];
        int n=distance.length;
        while(curr<0||start!=end){
            while (curr<0&&start!=end){
                curr=curr-(petrol[start]-petrol[end]);
                start=(start+1)%n;
                if(start==0){
                    return -1;
                }
            }
            curr=curr+(petrol[end]-distance[end]);
            end=(end+1)%n;
        }
        return start;
    }

}
