class Solution {
    static int MOD = (int) 1e9 + 7;
    public int xorAfterQueries(int[] nums, int[][] queries) {
        int q = queries.length;


        for(int i = 0; i < q; i++){
            //extract query
            int li = queries[i][0];
            int ri = queries[i][1];
            int ki = queries[i][2];
            int vi = queries[i][3];

            int idx = li;

            //update changes within a range (l --> r)
            while(idx <= ri){
                nums[idx] = (int) ((1L * nums[idx] * vi) % MOD);
                idx += ki;
            }
        }

        //return bitwise Or of all
        int bitwiseOr = nums[0];
        for(int i = 1;i<nums.length;i++){
            bitwiseOr ^= nums[i];
        }

        return bitwiseOr;
    }
}