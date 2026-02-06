class Solution {
    public int minRemoval(int[] nums, int k) {
        int n = nums.length;
        if(n==1)return 0;

        Arrays.sort(nums);

        if(n == 2 && (long) nums[0]*k >= (long) nums[1])return 0;

        int i = 0;
        int maxLen = 0;

        for(int j = 0;j<n;j++){
            while((long) nums[j] > (long) nums[i] * k)i++;

            maxLen = Math.max(maxLen,j-i+1);
        }

        return n - maxLen;
    }
}