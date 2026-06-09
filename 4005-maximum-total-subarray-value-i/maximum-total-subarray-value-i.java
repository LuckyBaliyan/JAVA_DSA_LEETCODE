class Solution {
    public long maxTotalValue(int[] nums, int k) {
        // ideally if we have to pick the max and min for a 
        // subArray but the max possible min and max for each 
        // subArray are global max and global min

        int max  = nums[0];
        int min = nums[0];

        //now w.k.t the for each optimal subarray we pick the 
        // value is still going to be globalMax and globalmin and
        // their diff = globalMax - globalMin

        for(int n : nums){
            max = Math.max(max, n);
            min = Math.min(min, n);
        }

        //now for k such subArrays the total sum is 
        // diff1 + diff2 + diff3 + ...... diffK

        return (long) (max - min) * k;
    }
}