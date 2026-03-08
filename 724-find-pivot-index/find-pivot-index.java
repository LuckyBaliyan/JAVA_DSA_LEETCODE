class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;

        int [] leftSum = new int [n];
        int [] rightSum = new int [n];

        leftSum[0] = nums[0];
        for(int i = 1;i<n;i++)leftSum[i] = leftSum[i-1] + nums[i];

        rightSum[n-1] = nums[n-1];
        for(int i = n-2;i>=0;i--)rightSum[i] = rightSum[i+1] + nums[i];

        for(int i = 0;i<n;i++){
            int left = 0;
            int right = 0;

            if(i - 1 >= 0)left = leftSum[i - 1];
            if(i + 1 < n)right = rightSum[i + 1];

            if(left == right)return i;
        }

        return -1;
    }
}