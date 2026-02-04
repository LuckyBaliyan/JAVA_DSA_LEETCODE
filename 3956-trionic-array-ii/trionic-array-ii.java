class Solution {
    long NEG = -100000000000000L;
    Long[][] dp;

    long f(int index, int status, int n, int[] nums) {
        if (index == n) {
            return status == 3 ? 0 : NEG;
        }

        if (dp[index][status] != null) return dp[index][status];

        long take = NEG;
        long notTake = NEG;

        if (status == 0) {
            notTake = f(index + 1, 0, n, nums);
        }

        if (status == 3) {
            take = nums[index];
        }

        if (index + 1 < n) {
            if (status == 0 && nums[index + 1] > nums[index]) {
                take = Math.max(take, nums[index] + f(index + 1, 1, n, nums));
            } 
            else if (status == 1) {
                if (nums[index + 1] > nums[index]) {
                    take = Math.max(take, nums[index] + f(index + 1, 1, n, nums));
                } else if (nums[index + 1] < nums[index]) {
                    take = Math.max(take, nums[index] + f(index + 1, 2, n, nums));
                }
            } 
            else if (status == 2) {
                if (nums[index + 1] < nums[index]) {
                    take = Math.max(take, nums[index] + f(index + 1, 2, n, nums));
                } else if (nums[index + 1] > nums[index]) {
                    take = Math.max(take, nums[index] + f(index + 1, 3, n, nums));
                }
            } 
            else if (status == 3 && nums[index + 1] > nums[index]) {
                take = Math.max(take, nums[index] + f(index + 1, 3, n, nums));
            }
        }

        return dp[index][status] = Math.max(take, notTake);
    }

    public long maxSumTrionic(int[] nums) {
        int n = nums.length;
        dp = new Long[n][4];
        return f(0, 0, n, nums);
    }
}

/*class Solution {
    public long maxSumTrionic(int[] nums) {
        int n = nums.length;

        //Brute force Solution
        return solveBrute(nums,n);
    }

    public static long solveBrute(int [] arr,int n){
        long maxSum = -(long)1e18;
        for(int i = 0;i<n-1;i++){
            for(int j = i+1;j<n;j++){
                if(isTrionic(arr,i,j)){
                   maxSum = Math.max(maxSum,computeSum(arr,i,j));
                }
            }
        }

       return maxSum == -(long)1e18 ? 0 : maxSum;
    }

    public static boolean isTrionic(int [] arr,int start,int end){
        if((end - start + 1) < 4)return false;

        int l = start,p = -1,q = -1,r = -1;

        for(int i = l;i<=end-1;i++){
            if(arr[i] < arr[i+1])continue;
            p = i;
            break;
        }

        if(p <= start)return false;

        for(int i = p;i<=end-1;i++){
            if(arr[i] > arr[i+1])continue;
            q = i;
            break;   
        }

        if(q <= p)return false;

        for(int i = q;i<=end-1;i++){
            if(arr[i] < arr[i+1])continue;
            else{
                r = i;
                break;
            }
        }

        if(r == -1)r = end;
        return q < r && r == end;
    }

    public static long computeSum(int [] arr,int start,int end){
        long localSum = 0;

        for(int i = start;i<=end;i++){
            localSum += arr[i];
        }

        return localSum;
    }
}
*/