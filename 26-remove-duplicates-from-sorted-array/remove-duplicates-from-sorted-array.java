class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;

        if(n == 1)return 1;

        int unique = 1;
        int prev = 0;
        int next = 1;

        while(next < n){
            while(next < n && nums[prev] == nums[next])next++;

            //overWrite
            if(next < n){
              nums[prev + 1] = nums[next];
              prev++;
              next++;
            }
        }

        return prev+1;
    }
}