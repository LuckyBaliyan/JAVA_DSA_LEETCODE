class Solution {
    static int [] parent;
    static int [] size;
    public  int removeStones(int[][] stones) {
        int n = stones.length;

        parent  = new int [n];
        size = new int [n];

        for(int i = 0;i<n;i++){
            parent[i] = i;
            size[i] = 1;
        }

        //Make both same row'th and clumn'th placed stones as a single 
        //component
        for(int i = 0;i<n-1;i++){
            for(int j = i+1;j<n;j++){
                if(stones[i][0] == stones[j][0] 
                || stones[i][1] == stones[j][1])union(i,j);
            }
        }

        int comp = 0;
        //count components 
        for(int i = 0;i<n;i++){
            if(find(i) == i)comp++;
        }


        return n - comp;
    }

    public static void union(int u,int v){
        int p_u = find(u);
        int p_v = find(v);

        if(size[p_u] < size[p_v]){
            parent[p_u] = p_v;
            size[p_v] += size[p_u];
        }
        else{
            parent[p_v] = p_u;
            size[p_u] += size[p_v];
        }
    }

    public static int find(int x){
        if(x == parent[x])return x;
        return parent[x] = find(parent[x]);
    }
}