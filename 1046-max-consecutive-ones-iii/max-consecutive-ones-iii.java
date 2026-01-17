class Solution {
    public int longestOnes(int[] nums, int k) {
      //return sw(nums,k); // O(N), O(1); 
      return bs(nums,k); //--> O(N log N), O(1)
    }

    public  static int bs(int [] nums,int k){
        int n = nums.length;

        int l = 0;
        int h = n;

        while(l<=h){
            int mid = l+(h-l)/2;

            if(isValid(nums,mid,k))l = mid+1;
            else h = mid - 1;
        }

        return h;
    }

    public static boolean isValid(int [] nums,int L,int k){
        int cntZeros = 0;
        int n = nums.length;

        for(int i = 0;i<L;i++){
            if(nums[i] == 0)cntZeros++;
        }

        if(cntZeros <= k)return true;

        //check shrink the current window
        for(int right =  L ;right < n;right++){
            if(nums[right] == 0)cntZeros++;
            if(nums[right - L] == 0)cntZeros--;

            if(cntZeros <= k)return true;
        }

        return false;
    }

    public static int sw(int [] nums,int k){
        int n = nums.length;
        int cntZero = 0;

        int left = 0;
        int maxLen = 0;

        for(int right = 0;right < n;right++){
            if(nums[right] == 0)cntZero++;

            while(cntZero > k){
                if(nums[left] == 0)cntZero--;
                left++;
            }

            maxLen = Math.max(maxLen,(right - left)+1);
        }

        return maxLen;
    }
}