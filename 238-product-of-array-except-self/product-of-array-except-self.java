class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;

        int [] leftPro = new int [n];
        int [] rightPro = new int [n];

        leftPro[0] = nums[0];
        rightPro[n-1] = nums[n-1];

        for(int i = 1; i<n; i++){
            leftPro[i] = leftPro[i-1] * nums[i];
        }

        for(int i = n-2; i>=0; i--){
            rightPro[i] = rightPro[i+1] * nums[i];
        }

        int [] res = new int [n];
        int k = 1;

        res[0] = rightPro[1];
        res[n-1] = leftPro[n-2];

        for(int i = 1; i<n-1; i++){
            res[k++] = leftPro[i-1]*rightPro[i+1];
        }

        return res;
    }
}