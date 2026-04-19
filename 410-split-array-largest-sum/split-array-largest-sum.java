class Solution {
    public int splitArray(int[] nums, int k) {
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        int sum = 0;

        for(int num : nums){
            max = Math.max(max, num);
            sum += num;
        }
        
        return solveBs(nums, n, k, max, sum);
    }

    public static int solveBs(int [] arr, int n, int k, int l, int h){
        int ans = 0;
        while(l <= h){
            int mid = l + (h - l)/2;

            if(canPartition(arr, mid, k)){
               ans = mid;
               h = mid - 1; //okay lets check for min possible
            }
            else{
                l = mid + 1; //found larger value
            }
        }

        return ans;
    }

    public static boolean canPartition(int [] arr, int bound, int k){
        int used = 1;
        int sum = 0;

        if(bound < arr[0])return false;

        for(int i = 0;i<arr.length;i++){
            if(sum + arr[i] > bound){
                used++;
                sum = arr[i];
            }
            else sum += arr[i];
        }

        return used <= k;
    }
}