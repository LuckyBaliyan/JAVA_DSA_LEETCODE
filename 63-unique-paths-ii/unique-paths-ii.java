class Solution {
    static int [][] memo;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;

        memo = new int [n][m];

        for(int [] arr:memo)Arrays.fill(arr,-1);

        return solveRec(obstacleGrid,n-1,m-1);
    }

    public static int solveRec(int [][] arr,int n, int m){
        if(n < 0 || m < 0)return 0;

        //if obstacle we can't take that path
        if(arr[n][m] == 1)return 0;

        if(n == 0 && m == 0)return 1;

        if(memo[n][m] != -1)return memo[n][m];

        return memo[n][m] = solveRec(arr,n-1,m) + solveRec(arr,n,m-1);
    }
}