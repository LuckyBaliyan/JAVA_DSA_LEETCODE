class Solution {
    static int[][][] Memo;
    public int maximumAmount(int[][] coins) {
        int n = coins.length;
        int m = coins[0].length;

        Memo = new int [n][m][3];
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                for(int k = 0;k<3;k++)Memo[i][j][k] = Integer.MIN_VALUE;
            }
        }

        return solveRec(coins,0,0,n,m,2);
    }

    public static int solveRec(int [][] arr, int i, int j,int n, int m, int left){
        //Base Case
        if(i == n-1 && j == m-1){
            if(arr[i][j] < 0 && left > 0)return 0;
            return arr[i][j];
        }

        //Boundary Condition
        if(i >= n || j >= m)return Integer.MIN_VALUE;

        //Give Previously computed branch result
        if(Memo[i][j][left] != Integer.MIN_VALUE)return Memo[i][j][left];

        //Take down & right  
        int take = Math.max(solveRec(arr,i+1,j,n,m,left), 
        solveRec(arr,i,j+1,n,m,left))+ arr[i][j];

        //skip logic based on left value obviously
        int skip = Integer.MIN_VALUE;
        if(arr[i][j] < 0 && left > 0){
            int skipDown = solveRec(arr,i+1,j,n,m,left-1);
            int skipRight = solveRec(arr,i,j+1,n,m,left-1);

            skip = Math.max(skipDown, skipRight);
        }

        return Memo[i][j][left] =  Math.max(skip, take);
    }
}