class Solution {
    public int[] constructTransformedArray(int[] nums) {
        //return solve1(nums);
        return solve2(nums);
    }

    public static int[] solve2(int [] nums){
        int n = nums.length;
        int [] res = new int[n];

        for(int i = 0;i<n;i++){
            int idx = (((i + nums[i])%n + n)%n);
            res[i] = nums[idx];
        }

        return res;
    }

    public static int[] solve1(int [] nums){
        int n = nums.length;
        int [] result = new int [n];

        for(int i = 0;i<n;i++){
            //Normalize The value to avoid repetitive runs
            int shift = nums[i] % n;

            int idx = (i + shift)%n;
            if(idx < 0){
                idx += n;
            }
            result[i] = nums[idx];
        }

        return result;
    }
}