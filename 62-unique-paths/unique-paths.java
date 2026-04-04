class Solution {
    static int [][] memo;
    public int uniquePaths(int m, int n) {
        memo = new int [n][m];
        
        for(int [] arr:memo)Arrays.fill(arr,-1);
        return solveRec(n - 1,m - 1);
    }

    public static int solveRec(int n, int m){
        if(n < 0 || m < 0)return 0;
        if(n == 0 && m == 0)return 1;

        if(memo[n][m] != -1)return memo[n][m];

        return memo[n][m] = solveRec(n-1,m) + solveRec(n,m-1);
    }
}