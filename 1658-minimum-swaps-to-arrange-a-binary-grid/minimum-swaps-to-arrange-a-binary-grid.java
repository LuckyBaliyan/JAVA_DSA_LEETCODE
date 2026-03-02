class Solution {
    public int minSwaps(int[][] grid) {
        int n = grid.length;
        int [] trailingZeros = new int [n];
        int steps = 0;

        //scan all the traling zeros for each row initially
        for(int i = 0;i<n;i++){
            for(int j = n-1;j>=0;j--){
                if(grid[i][j] == 1)break;
                if(grid[i][j] == 0)trailingZeros[i]++;
            }
        }

        //calculate the required zeros needed to be exactly at right
        // in each row
        for(int i = 0;i<n;i++){
           int required = (n - 1 - i);
           int j = i;

           while(j < n && trailingZeros[j] < required)j++;

           if(j == n)return -1;
           steps += (j - i);

           int temp = trailingZeros[j];
           while(j > i){
            trailingZeros[j] = trailingZeros[j-1];
            j--;
           }
           trailingZeros[i] = temp;
        }

        return steps;
    }
}