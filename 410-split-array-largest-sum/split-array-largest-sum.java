class Solution {
    public int splitArray(int[] nums, int k) {
        int n = nums.length;

        if(n < k)return -1;

        int lb = 0;
        int ub = 0;

        for(int i = 0;i<n;i++){
           lb  = Math.max(lb,nums[i]);
           ub += nums[i];
        }

        int  l = lb;
        int r =ub;

        while(l<=r){
            int mid = l+(r - l)/2;
            if(solve(nums,mid,k,n))r = mid-1;
            else l = mid+1;
        }

        return l;
    }

    public static boolean solve(int [] arr,int max,int k,int n){
        int sum = 0;
        int subArrays = 1;

        for(int i = 0;i<n;i++){
            if(arr[i] > max)return false;
            if(arr[i]+sum <= max){
               sum += arr[i];
            }
            else{
                subArrays++;
                sum = arr[i];
            }
        }

        return subArrays <= k;
    }
}