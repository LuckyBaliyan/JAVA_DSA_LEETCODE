class Solution {
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        boolean [][] visited = new boolean[n][m];

        //Check for the boundary 0s
        for(int j = 0;j<m;j++){
            if(board[0][j] == 'O' && !visited[0][j]){
                dfs(board,visited,0,j,n,m);
            }

            if(board[n-1][j] == 'O' && !visited[n-1][j]){
                dfs(board,visited,n-1,j,n,m);
            }
        }

        //for check left, right 0's
        for(int i = 0;i<n;i++){
            if(board[i][0] == 'O' && !visited[i][0]){
                dfs(board,visited,i,0,n,m);
            }

            if(board[i][m-1] == 'O' && !visited[i][m-1]){
                dfs(board,visited,i,m-1,n,m);
            }
        }

        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(board[i][j] == 'O' & !visited[i][j]){
                    board[i][j] = 'X';
                }
            }
        }

        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(board[i][j] == 'a'){
                    board[i][j] = 'O';
                }
            }
        }
    }

    public void dfs(char [][] grid,boolean [][] visited,int i,int j,int n,int m){
        visited[i][j] = true;

        if(i>0 && !visited[i-1][j] && grid[i-1][j] == 'O')
        dfs(grid,visited,i-1,j,n,m);
        if(i+1 < n && !visited[i+1][j] && grid[i+1][j]== 'O')
        dfs(grid,visited,i+1,j,n,m);
        if(j>0 && !visited[i][j-1] && grid[i][j-1]== 'O')
        dfs(grid,visited,i,j-1,n,m);
        if(j+1 < m && !visited[i][j+1] && grid[i][j+1]== 'O')
        dfs(grid,visited,i,j+1,n,m);
    }
}