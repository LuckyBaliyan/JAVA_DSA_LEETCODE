class Solution {
    private static final int MOD = 1_000_000_007;
    
    //Normal power function with MOD handling 
    public static int power(long a, long b){
        long ans = 1;
        a %= MOD;

        while(b > 0){
            if((b & 1) == 1){
                ans = (ans * a) % MOD;
            }

            a = (a * a) % MOD;
            b >>= 1;
        }

        return (int) ans;
    }
    
    //dfs function to get the max depth
    public static int dfs(int node, int par, List<List<Integer>> adj){
        int ans = 0;
        for(int child: adj.get(node)){
            if(child != par){
                ans = Math.max(ans, 1 + dfs(child, node, adj));
            }
        }

        return ans;
    }

    public int assignEdgeWeights(int[][] edges) {
        int n = edges.length + 2;

        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }

        //assign weights
        for(int [] e: edges){
            int u = e[0];
            int v = e[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        //no of ways usig 2 as edge weights are 2^depth of the tree

        //but we can have to find odd ways
        // so in that case 2^depth / 2 i.e  2^d / 2^1 i.e
        // 2^(d - 1) as total number of ways

        int depth = dfs(1, -1, adj);
        int res = power(2, depth - 1);

        return res;
    }
}