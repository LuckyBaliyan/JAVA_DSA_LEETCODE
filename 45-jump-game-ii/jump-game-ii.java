class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int maxReach = 0;
        int jumps = 0;

        if(n == 1)return 0;

        int currStep = 0;

        for(int i = 0; i<n-1; i++){
           if(maxReach < i)return 0;

           maxReach = Math.max(maxReach, i + nums[i]);
           if(i == currStep){
              jumps++;
              currStep = maxReach;
           }
        }

        return jumps;
    }
}