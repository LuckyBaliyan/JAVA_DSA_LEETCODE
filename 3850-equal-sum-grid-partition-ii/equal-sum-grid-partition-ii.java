/*class Solution {
    static int m, n;
    
    static void reverse(int[][] grid, int m, int n) {
        for (int i = 0; i < m / 2; i++) {
            int[] temp = grid[i];
            grid[i] = grid[m - 1 - i];
            grid[m - 1 - i] = temp;
        }
    }

    static int[][] transpose(int[][] grid, int m, int n) {
        int[][] transposed = new int[n][m];
    
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                transposed[j][i] = grid[i][j];
            }
        }
    
        return transposed;
    }

    /*static boolean checkHorizontal(int [][] grid, long total){
        Set<Integer> seen = new HashSet<>();

        long top = 0;
        for(int i = 0;i<m-1;i++){
               for(int j = 0;j<n;j++){
                   seen.add(grid[i][j]);
                   top += grid[i][j];
               }
   
           long bottom = 0;
           bottom = total - top;
           long diff = top - bottom;
   
           if(diff == 0)return true;
           if(diff == (long) grid[0][0])return true;
           if(diff == (long) grid[0][n-1])return true;
           if(diff == (long) grid[i][0])return true;
           if(i > 0 && n > 1 && seen.contains((long) diff))return true;
        }

        return false;
    }

    public boolean canPartitionGrid(int[][] grid) {

        m = grid.length;
        n = grid[0].length;

        long total = 0;

        for(int i = 0;i<m;i++){
            for(int j= 0;j<n;j++){
                total += grid[i][j];
            }
        }


        //cehck for horizontal cuts
        if(checkHorizontal(grid,total))return true;

        //try reverse halfs 
        reverse(grid,m,n);

        if(checkHorizontal(grid,total))return true;

        //if we don't get answer form horizontal cutting try vertical cutting
        grid = transpose(grid,m,n);
        int temp = m;
        m = n;
        n = temp;

       //now row --> cols and cols --> row so cehck with same function
       if(checkHorizontal(grid,total))return true;

       //check by reversing the halfs 
       reverse(grid,m,n);

       return checkHorizontal(grid,total);
    }
}*/

class Solution {

    boolean canRemove(int r1, int c1, int r2, int c2, int i, int j) {
        int rows = r2 - r1 + 1;
        int cols = c2 - c1 + 1;

        if (rows * cols == 1) return false;

        if (rows == 1) {
            return (j == c1 || j == c2);
        }

        if (cols == 1) {
            return (i == r1 || i == r2);
        }

        return true;
    }

    public boolean canPartitionGrid(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        long[] prefRow = new long[n];
        long[] prefCol = new long[m];

        Map<Long, List<int[]>> mp = new HashMap<>();

        for (int i = 0; i < n; i++) {
            long val = 0;
            for (int j = 0; j < m; j++) {
                val += grid[i][j];
                mp.computeIfAbsent((long)grid[i][j], k -> new ArrayList<>()).add(new int[]{i, j});
            }
            prefRow[i] = val + (i > 0 ? prefRow[i - 1] : 0);
        }

        for (int j = 0; j < m; j++) {
            long val = 0;
            for (int i = 0; i < n; i++) {
                val += grid[i][j];
            }
            prefCol[j] = val + (j > 0 ? prefCol[j - 1] : 0);
        }

        long total = prefRow[n - 1];

        for (int i = 0; i < n - 1; i++) {
            long top = prefRow[i];
            long bottom = total - top;

            if (top == bottom) return true;

            long diff = Math.abs(top - bottom);

            if (!mp.containsKey(diff)) continue;

            if (top > bottom) {
                for (int[] p : mp.get(diff)) {
                    int x = p[0], y = p[1];
                    if (x <= i && canRemove(0, 0, i, m - 1, x, y)) return true;
                }
            } else {
                for (int[] p : mp.get(diff)) {
                    int x = p[0], y = p[1];
                    if (x > i && canRemove(i + 1, 0, n - 1, m - 1, x, y)) return true;
                }
            }
        }

        for (int j = 0; j < m - 1; j++) {
            long left = prefCol[j];
            long right = total - left;

            if (left == right) return true;

            long diff = Math.abs(left - right);

            if (!mp.containsKey(diff)) continue;

            if (left > right) {
                for (int[] p : mp.get(diff)) {
                    int x = p[0], y = p[1];
                    if (y <= j && canRemove(0, 0, n - 1, j, x, y)) return true;
                }
            } else {
                for (int[] p : mp.get(diff)) {
                    int x = p[0], y = p[1];
                    if (y > j && canRemove(0, j + 1, n - 1, m - 1, x, y)) return true;
                }
            }
        }

        return false;
    }
}