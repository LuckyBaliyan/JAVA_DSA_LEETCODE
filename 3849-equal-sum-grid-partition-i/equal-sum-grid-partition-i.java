class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        long total = 0;

        //calculate the totalSum = prfixHorizontal + prfixVertical
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                total += grid[i][j];
            }
        }

        //if sum is odd it can't be divide equally 
        if(total %  2 != 0)return false;


        long [] rowPrif = new long [n];
       
       // calculate the total horizontal sum
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                rowPrif[i] += grid[i][j];
            }
        }

        long curr = 0;
        //check till the secLast row because we have to divide in 2 sections
        for(int i = 0;i<n-1;i++){
            curr += rowPrif[i];
            if(curr * 2 == total)return true;
        }

        long [] columPrif = new long [m];

        for(int i = 0;i<n;i++){
            for(int  j = 0;j<m;j++){
                columPrif[j] += grid[i][j];
            }
        }

        curr = 0;
        //similarly here also n point to cehck all columns becuase we 
        // have to divide 2 sections
        for(int j = 0;j<m-1;j++){
            curr += columPrif[j];

            if(curr*2 == total)return true;
        }

        return false;
    }
}