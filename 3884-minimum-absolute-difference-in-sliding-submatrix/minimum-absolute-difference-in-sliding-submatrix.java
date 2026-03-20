class Solution {
    public int[][] minAbsDiff(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;

        //Given:- req size :- (n - k + 1)x(m - k + 1)
        int [][] ans = new int[n - k + 1][m - k  + 1];

        for(int i = 0;i<n - k + 1;i++){
            for(int j = 0;j<m - k + 1;j++){
                ArrayList<Integer> elms = new ArrayList<>();
            
                //fill the values of the submatrix
                for(int x = i;x < i + k;x++){
                   for(int y = j;y< j + k;y++){
                    elms.add(grid[x][y]);
                   }
                }
    
                //sort the list values for adjacent (easy comparison) of minDiff
                Collections.sort(elms);
                int minDiff = Integer.MAX_VALUE;
    
                for(int e  = 1;e<elms.size();e++){
                    if(elms.get(e).equals(elms.get(e - 1))){
                        continue;
                    }
                    minDiff = Math.min(
                            minDiff,
                        (elms.get(e) - elms.get(e-1))
                        );
                }

                ans[i][j] = (minDiff == Integer.MAX_VALUE) ? 0 : minDiff;
            }
        }

        return ans;
    }
}