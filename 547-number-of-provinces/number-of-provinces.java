class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;

        boolean [] visited = new boolean [n];
        int provis = 0;
        
        for(int i =0;i<n;i++){
            if(!visited[i]){
                dfs(isConnected,i,visited);
                provis++;
            }
        }

        return provis;
    }

    public static void dfs(int [][] grid,int i,boolean [] visited){
        int n = grid.length;
        visited[i] = true;

        for(int j = 0;j<n;j++){
            if(!visited[j] && grid[i][j] == 1)dfs(grid,j,visited);
        }
    }
}