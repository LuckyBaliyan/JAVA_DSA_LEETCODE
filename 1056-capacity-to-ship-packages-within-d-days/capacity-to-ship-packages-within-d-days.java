class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int n = weights.length;
        int low = 0;
        int high = 0;

        for(int i:weights){
            low = Math.max(low,i);
            high += i;
        }

        while(low < high){
          int mid = low + (high - low)/2;
          if(helper(mid,weights,days)) high = mid;
          else low = mid+1;
        }

        return low;
    }

    public static boolean helper(int sum,int [] weights,int d){
        int days = 1;
        int load = 0;

        for(int i = 0;i<weights.length;i++){
            if(load + weights[i] > sum){
                days++;
                load = weights[i];
            }
            else{
                load += weights[i];
            }
        }

        return days <= d;
    }
}