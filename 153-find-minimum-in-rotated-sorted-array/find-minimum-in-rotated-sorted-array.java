class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;

        //search on both diraction for smallest possible
        int l = 0;
        int h = n-1;
        int min = Integer.MAX_VALUE;

        while(l<=h){
            int mid = l + (h - l)/ 2;
            min = Math.min(min, nums[mid]);

            if(nums[l] > nums[mid]){
                l++;
                continue;
            }

            if(nums[l] < nums[mid]){
                min = Math.min(min, nums[l]);
            }

            l = mid + 1;
        }

        return min;
    }
}