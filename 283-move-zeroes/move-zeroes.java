class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;

        if(n == 1 || n == 0)return;

        int prev = 0;
        int next = 1;

        while(next < n){
            //if prev == 0 and next != 0 swap and move
            if(nums[prev] == 0 && nums[next] != 0){
                int temp = nums[prev];
                nums[prev] = nums[next];
                nums[next] = temp;
            }
            else if (nums[prev] == 0 && nums[next] == 0){
                next++;
                continue;
            }

            prev++;
            next++;
        }
    }
}