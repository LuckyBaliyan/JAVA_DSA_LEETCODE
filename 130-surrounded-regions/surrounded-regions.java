class Solution {
    static int n, m;
    static boolean [][] visited;

    public void solve(char[][] board) {
        n = board.length;
        m = board[0].length;

        visited = new boolean [n][m];
  
        //cehck and mark boundary 0's as unchangable
        for(int i = 0; i<n; i++){
            if(board[i][0] == 'O' && !visited[i][0]){
                dfs(board, i, 0);
                board[i][0] = 'a';
            }
        }

        for(int i = 0; i<n; i++){
            if(board[i][m-1] == 'O' && !visited[i][m-1]){
                dfs(board, i, m-1);
                board[i][m-1] = 'a';
            }
        }

        for(int i = 0; i<m; i++){
            if(board[0][i] == 'O' && !visited[0][i]){
                dfs(board, 0, i);
                board[0][i] = 'a';
            }
        }

        for(int i = 0; i<m; i++){
            if(board[n-1][i] == 'O' && !visited[n-1][i]){
                dfs(board, n-1, i);
                board[n-1][i] = 'a';
            }
        }

        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(board[i][j] == 'O' && !visited[i][j]){
                    board[i][j] = 'X';
                }
                else if (board[i][j] == 'a')board[i][j] = 'O';
            }
        }
    }

    public void dfs(char [][] arr, int r, int c){
        visited[r][c] = true;

        if(r - 1 >= 0 && !visited[r-1][c] && arr[r-1][c] == 'O')dfs(arr, r-1, c);
        if(r+1 < n && !visited[r+1][c] && arr[r+1][c] == 'O')dfs(arr, r+1, c);
        if(c - 1 >= 0 && !visited[r][c-1] && arr[r][c-1] == 'O')dfs(arr, r, c-1);
        if(c + 1 < m && !visited[r][c+1] && arr[r][c+1] == 'O')dfs(arr, r, c+1);
    }
}