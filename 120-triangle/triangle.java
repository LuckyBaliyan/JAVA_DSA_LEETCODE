class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[triangle.size()][];
        for (int i = 0; i < triangle.size(); i++) {
         dp[i] = new int[triangle.get(i).size()];
         Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        //return solve(0,0,triangle);
        return bottomUp(0,0,triangle);
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
    /*
    public static int solve(int row,int col,List<List<Integer>> triangle,int [][] dp){
        if(triangle.size() - 1 == row){
            return triangle.get(row).get(col);
        }

        if(dp[row][col] != Integer.MAX_VALUE)return dp[row][col];

        return dp[row][col] = Math.min(solve(row+1,col,triangle,dp),solve(row+1,col+1,triangle,dp))+triangle.get(row).get(col);
    }
    */

    public static int bottomUp(int row,int col,List<List<Integer>> triangle){
        int n = triangle.size();
        int [][] dp =  new int[triangle.size()][];
        for (int i = 0; i < triangle.size(); i++) {
         dp[i] = new int[triangle.get(i).size()];
        }

        dp[0][0] = triangle.get(0).get(0);


        for(int i = 0;i<triangle.get(n-1).size();i++){
            dp[n-1][i] = triangle.get(n-1).get(i);
        }

        for(int i = n-2;i>=0;i--){
            for(int j=0;j<triangle.get(i).size();j++){
                int down = dp[i+1][j];
                int dig = dp[i+1][j+1];

                dp[i][j] = Math.min(down,dig)+triangle.get(i).get(j);
            }
        }

        return dp[0][0];
    }

}