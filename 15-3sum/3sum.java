class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;

        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        for(int i = 0; i<n; i++){
            if(i > 0 && nums[i] == nums[i-1])continue;

            int j = i+1;
            int k = n-1;


            while(j < k){
                int sum = nums[i] + nums[k] + nums[j];

                if(sum < 0)j++;
                else if(sum > 0)k--;
                else{
                    res.add(new ArrayList<>(
                        Arrays.asList(nums[i], nums[j], nums[k]))
                    );

                    k--;
                    j++;

                    while(j < k && nums[j] == nums[j-1])j++;
                    while(j < k && nums[k] == nums[k+1])k--;
                }
            }
        }

        return res;
    }
}