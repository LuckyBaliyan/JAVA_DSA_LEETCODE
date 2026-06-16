class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        int prefix = 0;
        map.put(0, -1);

        for(int i = 0; i < n; i++){
            prefix =  (prefix + nums[i]) % k;

            if(map.containsKey(prefix)){
                if(i - map.get(prefix) > 1)return true;
            }
            else{
                map.put(prefix, i);
            }
        }

        return false;
    }
}