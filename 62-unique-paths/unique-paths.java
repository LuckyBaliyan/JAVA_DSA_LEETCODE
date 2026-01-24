class Solution {
    public static int [][] memo;
    public int uniquePaths(int m, int n) {
        //return solveRec(m - 1,n - 1);

        memo = new int [m][n];
        for(int [] arr:memo)Arrays.fill(arr,-1);

        return solveMemo(m-1,n-1,memo);
    }

    public static int solveMemo(int m,int n,int [][] memo){
        if(m < 0 || n < 0)return 0;

        if(m==0 && n == 0)return 1;

        if(memo[m][n] != -1)return memo[m][n];

        return memo[m][n] = solveMemo(m-1,n,memo) + solveMemo(m,n-1,memo);
    }

    // Recursive solution with --> O(2^(m+n)) , O(2N)
    public static int solveRec(int top,int left){
        if(top < 0 || left < 0)return 0;
        if(top == 0 && left == 0)return 1;

        return solveRec(top - 1,left) +  solveRec(top,left - 1);
    }
}