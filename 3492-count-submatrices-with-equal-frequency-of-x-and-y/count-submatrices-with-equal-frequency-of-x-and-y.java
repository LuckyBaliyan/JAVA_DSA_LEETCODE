class Solution {
    public int numberOfSubmatrices(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int [][] prefix = new int [n][m];
        int [][] countX = new int [n][m];

        if(grid[0][0] == 'X')countX[0][0] = 1;

        prefix[0][0] = (grid[0][0] == 'X')?1:(grid[0][0] == 'Y')?-1:0;

        for(int i = 1;i<n;i++){
            prefix[i][0] = 
            prefix[i-1][0] + ((grid[i][0] == 'X')?1:(grid[i][0] == 'Y')?-1:0);

            countX[i][0] = countX[i-1][0] +  
            ((grid[i][0] == 'X')?1:0);
        }

        
        for(int i = 1;i<m;i++){
            prefix[0][i] = 
            prefix[0][i-1] + ((grid[0][i] == 'X')?1:(grid[0][i] == 'Y')?-1:0);

            countX[0][i] = countX[0][i-1] + ((grid[0][i] == 'X')?1:0);
        }

        for(int i = 1;i<n;i++){
            for(int j = 1;j<m;j++){
                char ch = grid[i][j];
                int val = (ch == 'X')?1:(ch == 'Y')?-1:0;
                int isX = ((grid[i][j] == 'X')?1:0);

                prefix[i][j] = ( 
                    val + prefix[i-1][j] + 
                    prefix[i][j-1] - prefix[i-1][j-1]
                );

                countX[i][j] = (
                    isX + countX[i-1][j] + countX[i][j-1] - countX[i-1][j-1]
                );
            }
        }

        int cnt = 0;

        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(countX[i][j] > 0 && prefix[i][j] == 0)cnt++;
            }
        }


        return cnt;
    }
}