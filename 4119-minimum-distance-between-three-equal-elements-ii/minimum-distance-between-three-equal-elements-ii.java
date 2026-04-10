class Solution {
    public int minimumDistance(int[] nums) {
        int n = nums.length;
        int ans = Integer.MAX_VALUE;

        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

        //for each num store it's accourance index wise in a list
        for(int i = 0;i<n;i++){
            map.computeIfAbsent(nums[i],k->new ArrayList<>()).add(i);
        }

        for(ArrayList<Integer> list : map.values()){
            int size = list.size();
            //if triplet was there
            if(size < 3)continue;

            //moving window of 3 like there is a probability of same values 
            // but more than 3 ex:- [1,1,1,1,1,1,1] here we will check each window 
            // of 3
            for(int i = 0;i<=size-3;i++){
                int a = list.get(i);
                int k = list.get(i+2);

                ans = Math.min(ans, 2*(k-a));
            }
        }

        return (ans == Integer.MAX_VALUE)? -1: ans;
    }
}