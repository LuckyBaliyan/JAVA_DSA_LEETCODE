class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int cntZero = 0;

        int left = 0;
        int maxLen = 0;

        for(int right = 0;right < n;right++){
            if(nums[right] == 0)cntZero++;

            while(cntZero > k){
                if(nums[left] == 0)cntZero--;
                left++;
            }

            maxLen = Math.max(maxLen,(right - left)+1);
        }

        return maxLen;
        
    }
}