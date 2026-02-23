class Solution {
    static int provins;
    static int [] parent,size;
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        provins = n;

        parent = new int [n];
        size = new int [n];

        for(int i = 0;i<n;i++){
            parent[i] = i;
            size[i] = 1;
        }

        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                if(isConnected[i][j] == 1){
                    union(i,j);
                }
            }
        }

        return provins;
    }

    public static void union(int u,int v){
      int p_u = find(u);
      int p_v = find(v);

      if(p_u == p_v)return;

      if(size[p_u] < size[p_v]){
        parent[p_u] = p_v;
        size[p_v] += size[p_u];
      }
      else{
        parent[p_v] = p_u;
        size[p_u] += size[p_v];
      }

      provins--;
    }

    public static int find(int x){
        if(x == parent[x])return x;
        return parent[x] = find(parent[x]);
    }
}