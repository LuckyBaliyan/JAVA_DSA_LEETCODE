class Solution {
    static int [] par;
    static int [] size;
    public int makeConnected(int n, int[][] connections) {
        int m = connections.length;
 
        if(m < n - 1)return -1;

        par = new int[n];
        size = new int[n];

        for(int i =0;i<n;i++){
            par[i] = i;
            size[i] = 1;
        }

        for(int [] e:connections){
           int u = e[0];
           int v = e[1];

           union(u,v);
        }

        int comp = 0;
        for(int i = 0;i<n;i++){
            if(par[i] == i)comp++;
        }

        return comp - 1;
    }

    public static void union(int u,int v){
        int pu = find(u);
        int pv = find(v);

        if(size[pu] < size[pv]){
            par[pu] = pv;
            size[pv] += size[pu];
        }
        else{
            par[pv] = pu;
            size[pu] += size[pv];
        }
    }

    public static int find(int x){
        if(x == par[x])return x;
        return par[x] = find(par[x]);
    }
}