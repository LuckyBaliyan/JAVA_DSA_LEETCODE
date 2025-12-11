class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[triangle.size()][];
        for (int i = 0; i < triangle.size(); i++) {
         dp[i] = new int[triangle.get(i).size()];
         Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        //return solve(0,0,triangle);
        return solve(0,0,triangle,dp);
    }

    //Plain Recursion -->
    /*
    public static int solve(int row,int col,List<List<Integer>> triangle){
        if(triangle.size() - 1 == row){
            return triangle.get(row).get(col);
        }

        return Math.min(solve(row+1,col,triangle),solve(row+1,col+1,triangle))+triangle.get(row).get(col);
    }
    */

    //Memoization Solution
    public static int solve(int row,int col,List<List<Integer>> triangle,int [][] dp){
        if(triangle.size() - 1 == row){
            return triangle.get(row).get(col);
        }

        if(dp[row][col] != Integer.MAX_VALUE)return dp[row][col];

        return dp[row][col] = Math.min(solve(row+1,col,triangle,dp),solve(row+1,col+1,triangle,dp))+triangle.get(row).get(col);
    }

}