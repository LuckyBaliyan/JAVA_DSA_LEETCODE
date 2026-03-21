class Solution {
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        int n = grid.length;
        int m = grid[0].length;

        int x2 = x + k - 1;

        for(int i = x;i < x2 ;i++){
            for(int j = y;j<= y + k - 1;j++){
                int temp = grid[i][j];
                grid[i][j] = grid[x2][j];
                grid[x2][j] = temp; 
            }

            x2--;
        }

        return grid;
    }
}