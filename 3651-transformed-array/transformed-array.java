class Solution {
    public int[] constructTransformedArray(int[] nums) {
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