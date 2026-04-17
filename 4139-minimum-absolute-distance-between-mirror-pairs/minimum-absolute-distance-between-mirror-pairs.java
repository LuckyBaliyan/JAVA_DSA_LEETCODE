class Solution {
    public static int rev(int num){
        int rev = 0;
        while( num > 0){
            rev = rev * 10 + (num % 10);
            num /= 10;
        }

        return rev;
    }
    public int minMirrorPairDistance(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();

        int minDist = Integer.MAX_VALUE;

        for(int i = 0; i<n; i++){
            if(map.containsKey(nums[i])){
              minDist = Math.min(minDist, Math.abs(i - map.get(nums[i])));
            }

            map.put(rev(nums[i]),i);
        }

        return minDist == Integer.MAX_VALUE ? -1 : minDist;
    }
}