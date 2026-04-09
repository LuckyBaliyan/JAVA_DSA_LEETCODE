class Solution {
    static int MOD = (int) 1e9 + 7;
    
    static long power(long base, long exp) {
        long res = 1;
        base %= MOD;

        while(exp > 0){
            if((exp & 1) == 1){
                res = (res * base) % MOD;
            }
            base = (base * base) % MOD;
            exp >>= 1;
        }
        return res;
    }

    public int xorAfterQueries(int[] nums, int[][] queries) {
        int q = queries.length;
        int n = nums.length;

        int blockSize = (int) Math.ceil(Math.sqrt(n));
        HashMap<Integer, ArrayList<ArrayList<Integer>>> map = new HashMap<>();

        for(int i = 0; i < q; i++){
            //extract query
            int li = queries[i][0];
            int ri = queries[i][1];
            int ki = queries[i][2];
            int vi = queries[i][3];

            if(ki>=blockSize){
                int idx = li;

                //update changes within a range (l --> r)
                while(idx <= ri){
                    //handle the value from causing the overflow error
                    // 1 <= nums[i] <= 10^9
                    nums[idx] = (int) ((1L * nums[idx] * vi) % MOD);
                    idx += ki;
                }
            }
            else{
                //put the ki < sqrt(n) queries for later computation
                map.putIfAbsent(ki, new ArrayList<>());
                map.get(ki).add(new ArrayList<>(Arrays.asList(li, ri, ki, vi)));
            }
        }

        for(Map.Entry<Integer, ArrayList<ArrayList<Integer>>> entry : map.entrySet()){
            int [] diff = new int [n];
            Arrays.fill(diff,1);

            int key = entry.getKey();

            for(ArrayList<Integer> query: entry.getValue()){
                int L = query.get(0);
                int R = query.get(1);
                int V = query.get(3);

                diff[L] = (int)((1L * diff[L] * V) % MOD);
                int steps = (R-L) / key;
                int next = L + (steps + 1) * key;

                if(next < n){
                    diff[next] = (int)((1L * diff[next] * power(V, MOD - 2)) % MOD);
                }

            }
            
            //calculate cummalative product
            for(int i = 0; i < n; i++){
                if(i-key >= 0)
                diff[i] = (int)((1L * diff[i] * diff[i - key]) % MOD);
            }
           
           //place back in nums
            for(int i = 0; i < n; i++){
                nums[i] = (int)((1L * nums[i] * diff[i]) % MOD);
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