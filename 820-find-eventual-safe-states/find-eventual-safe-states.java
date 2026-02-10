class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        List<Integer> ans = new ArrayList<>();

        int [] visited = new int [n];

        for(int i = 0;i<n;i++){
           if(dfs(graph,visited,i))ans.add(i);
        }

        return ans;
    }

    public static boolean dfs(int [][] graph,int [] visited,int src){
        if(visited[src] != 0){
            return visited[src] == 2;
        }

        visited[src] = 1;

        for(int i =0;i<graph[src].length;i++){
            if(!dfs(graph,visited,graph[src][i]))return false;
        }
        
        visited[src] = 2;
        return true;
    }
}