class Solution {
    public boolean isPossibleToSplit(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int n = nums.length;

        for(int i = 0;i<n;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            
            if(map.containsKey(nums[i])){
                if(map.get(nums[i]) > 2)return false;
            }
        }

        return true;
    }
}