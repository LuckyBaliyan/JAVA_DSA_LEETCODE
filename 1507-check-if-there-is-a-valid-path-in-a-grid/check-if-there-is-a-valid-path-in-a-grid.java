class Solution {
    static Map<Integer, int[][]> dir = new HashMap<>();
    static int n, m;
    static boolean [][] visited;

    static {
        dir.put(1, new int[][]{{0, -1}, {0, 1}});
        dir.put(2, new int[][]{{-1, 0}, {1, 0}});
        dir.put(3, new int[][]{{0, -1}, {1, 0}});
        dir.put(4, new int[][]{{0, 1}, {1, 0}});
        dir.put(5, new int[][]{{0, -1}, {-1, 0}});
        dir.put(6, new int[][]{{-1, 0}, {0, 1}});
    }

    public boolean hasValidPath(int[][] grid) {
        n = grid.length;
        m = grid[0].length;

        visited = new boolean [n][m];

        return dfs(grid,0,0);
    }

    public static boolean dfs(int [][] arr, int i, int j){
        if(i == n-1 && j == m-1)return true;
        visited[i][j] = true;

        for(int [] d : dir.get(arr[i][j])){
            int new_i = i + d[0];
            int new_j = j + d[1];

            if(new_i < 0 || new_i >= n || new_j < 0 || new_j >=m ||
            visited[new_i][new_j])continue;

            for(int [] back : dir.get(arr[new_i][new_j])){
                if(new_i + back[0] == i && new_j + back[1] == j){
                    if(dfs(arr,new_i,new_j))return true;
                }
            }  
        } 

        return false;
    }
}