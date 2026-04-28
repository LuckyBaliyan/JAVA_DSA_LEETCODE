class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;

        /*Arrays.sort(nums);

        if(nums[0] != 0)return 0;
        if(nums[n-1] != n)return n;

        for(int i = 1; i<n; i++){
            if(nums[i] != i)return i;
        }

        return -1;*/

        //sum of n natural nums
        int target = n * ( n + 1 ) / 2;
        int calculated = 0;

        for(int num : nums)calculated += num;

        return target - calculated;
    }
}