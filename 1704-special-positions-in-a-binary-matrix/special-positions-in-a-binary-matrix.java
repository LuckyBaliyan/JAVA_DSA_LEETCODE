class Solution {
    public int numSpecial(int[][] mat) {
       return approach1(mat);
    }

    public int approach1(int [][] mat){
         int m = mat.length;
        int n = mat[0].length;

        int specials = 0;

        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(mat[i][j] == 1 && helper(i,j,n,m,mat))specials++;
            }
        }

        return specials;
    }

    public boolean helper(int row,int col,int n,int m,int [][] arr){
        int rp = m-1;
        int cp = n-1;

        while(rp >= 0){
            if(arr[rp][col] == 1 && rp != row)return false;
            rp--;
        }

        while(cp >= 0){
            if(arr[row][cp] == 1 && cp != col)return false;
            cp--;
        }

        return true;
    }
}