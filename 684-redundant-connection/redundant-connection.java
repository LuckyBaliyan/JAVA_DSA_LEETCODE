class Solution {
    static int [] parent;
    static int [] size;

    public int[] findRedundantConnection(int[][] edges) {
        // O(alpha*(n)) usually TC for DSU
        //return viaDsu(edges);


        return viaDfs(edges);
    }

    public static int[] viaDfs(int [][] edges){
        int n = edges.length;
        int [] res = new int [2];

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i = 0;i<=n;i++){
            adj.add(new ArrayList<>());
        }

        for(int [] e:edges){
            int u = e[0];
            int v = e[1];

            boolean [] visited = new boolean [n+1];

            if(dfs(u,v,visited,adj)){
                res[0] = u;
                res[1] = v;
            }
            else{
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
        }

        return res;
    }

    public static boolean dfs(int node,int dest,boolean [] visited,
    ArrayList<ArrayList<Integer>> adj){
        visited[node] = true;
        
        if(node == dest)return true;
        for(int ne:adj.get(node)){
            if(!visited[ne]){
                if(dfs(ne,dest,visited,adj))return true;
            }
        }

        return false;
    }

    public static int[] viaDsu(int [][] edges){
         // use dsu to simply connect edges and check which 
        // Edges are already a part of a component and can cause 
        // cycles. 
        int n = edges.length;
        parent  = new int[n+1];
        size = new int[n+1];

        for(int i=0;i<=n;i++){
            parent[i] = i;
            size[i] = 1;
        }

       //Now Dynamically start adding edges and check for the last cycle causing
       // edge if an edge causing cycle will be added to result else union(u,v)
       int [] res = new int [2];

       for(int [] e:edges){
        int u = e[0];
        int v = e[1];
        
        if(find(u) == find(v)){
            res[0] = u;
            res[1] = v;
        }
        else union(u,v);
       }

       return res;
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