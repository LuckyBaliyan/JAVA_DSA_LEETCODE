class Solution {
    public int longestBalanced(int[] nums) {
        int n = nums.length;
        if(n < 2)return 0;
        int maxLen = 0;

        for(int i = 0;i<n;i++){
            HashSet<Integer> evenSet = new HashSet<>();
            HashSet<Integer> oddSet = new HashSet<>();
            for(int j = i;j<n;j++){
               if(nums[j] % 2 == 0)evenSet.add(nums[j]);
               else oddSet.add(nums[j]);

              if(evenSet.size() == oddSet.size()){
                maxLen = Math.max(maxLen,(j-i)+1);
               }
            }

            if(maxLen == n)return n;
        }

        return maxLen;
    }
}