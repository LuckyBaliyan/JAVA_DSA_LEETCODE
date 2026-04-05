class Solution {
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        Integer[][][] dp = new Integer[n][n][n];

        int ans = solve(grid, 0, 0, 0, dp);
        return Math.max(0, ans);
    }

    // r1, c1 = person A
    // r2, c2 = person B
    public int solve(int[][] grid, int r1, int c1, int r2, Integer[][][] dp) {
        int n = grid.length;
        int c2 = r1 + c1 - r2;  // derived column

        //invalid cases
        if (r1 >= n || c1 >= n || r2 >= n || c2 >= n ||
            grid[r1][c1] == -1 || grid[r2][c2] == -1) {
            return Integer.MIN_VALUE;
        }

        // reached destination
        if (r1 == n - 1 && c1 == n - 1) {
            return grid[r1][c1];
        }

        if (dp[r1][c1][r2] != null) {
            return dp[r1][c1][r2];
        }

        int cherries = grid[r1][c1];

        // avoid double counting same cell
        if (r1 != r2) {
            cherries += grid[r2][c2];
        }

        // explore all 4 moves
        int f1 = solve(grid, r1, c1 + 1, r2, dp);     // right, right
        int f2 = solve(grid, r1 + 1, c1, r2, dp);     // down, right
        int f3 = solve(grid, r1, c1 + 1, r2 + 1, dp); // right, down
        int f4 = solve(grid, r1 + 1, c1, r2 + 1, dp); // down, down

        int best = Math.max(Math.max(f1, f2), Math.max(f3, f4));

        // if all paths invalid
        if (best == Integer.MIN_VALUE) {
            return dp[r1][c1][r2] = Integer.MIN_VALUE;
        }

        return dp[r1][c1][r2] = cherries + best;
    }
}