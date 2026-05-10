class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int count  = 0;
        int prefixSum = 0;

        for(int i = 0; i<n; i++){
            prefixSum += nums[i];
            int res = prefixSum - k;
            count += map.getOrDefault(prefixSum - k, 0);
            map.put(prefixSum,map.getOrDefault(prefixSum, 0)+1);
        }

        return count;
    }
}