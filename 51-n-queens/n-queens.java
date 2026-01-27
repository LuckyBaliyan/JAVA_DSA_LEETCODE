class Solution {
    public List<List<String>> solveNQueens(int n) {
        char [][] board = new char[n][n];
        for(char [] a:board)Arrays.fill(a,'.');
        List<List<String>> res = new ArrayList<>();

        solveNq(board,0,n,res);
        return res;
    }

    public void solveNq(char [][] board,int row,int n,
    List<List<String>> res){
        if(row == n){
            List<String> temp = new ArrayList<>();

            for(int i = 0;i<n;i++){
                temp.add(new String(board[i])); // each row completely
            }

            res.add(temp);
            return;
        }

        for(int col = 0;col<n;col++){
          if(isSafe(board,row,col,n)){
            board[row][col] = 'Q';
            solveNq(board,row+1,n,res);
            board[row][col] = '.';
          }
        }
    }

    public boolean isSafe(char [][] board,int row,int col,int n){
        for(int i = 0;i<row;i++){
            if(board[i][col] == 'Q')return false;
        }

        for(int i = row - 1,j = col - 1;i>=0 && j >= 0;i--,j--){
            if(board[i][j] == 'Q')return false;
        }

        for(int i = row - 1,j = col + 1;i>=0 && j < n;j++,i--){
            if(board[i][j] == 'Q')return false;
        }

        return true;
    }
}