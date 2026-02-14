class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        ArrayList<ArrayList<Integer>> adj =  new ArrayList<>();
        boolean [] visited = new boolean [n];

        for(int i = 0;i<n;i++)adj.add(new ArrayList<>());

        for(int [] e:edges){
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        return dfs(adj,visited,source,destination);
    }

    public static boolean dfs(ArrayList<ArrayList<Integer>> adj,boolean [] visited,int s,int dest){
        visited[s] = true;

        if(s == dest)return true;

        for(int i:adj.get(s)){
            if(!visited[i]){
                visited[i] = true;
                if(dfs(adj,visited,i,dest))return true;
            }
        }

        return false;
    }
}