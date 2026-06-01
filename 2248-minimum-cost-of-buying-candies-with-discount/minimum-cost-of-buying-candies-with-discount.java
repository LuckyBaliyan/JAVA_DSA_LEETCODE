class Solution {
    public int minimumCost(int[] cost) {
        int n = cost.length;
        Arrays.sort(cost);

        int count = 0;
        int res = 0;

        for(int i = n-1; i>=0; i--){
            if(count == 2){
                count = 0;
                continue;
            }

            res += cost[i];
            count++;
        }

        return res;
    }
}