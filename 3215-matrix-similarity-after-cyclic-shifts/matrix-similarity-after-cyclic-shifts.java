class Solution {
    public boolean areSimilar(int[][] mat, int k) {
        int n = mat.length;
        int m = mat[0].length;

        k = k % m;

        if(k == 0)return true;
        
        int [][] temp = new int [n][m];

        for(int i = 0;i<n;i++){
            if(i % 2 == 0){
                leftShift(i,mat,temp,k);
            }
            else{
                rightShift(i,mat,temp,k);
            }
        }

        //compare at last 
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(temp[i][j] != mat[i][j])return false;
            }
        }

        return true;
    }

    public static void leftShift(int row, int [][] mat, int [][] temp, int k){
        int m = mat[0].length;

        //copy the curr row of mat to temp
        for(int i = 0;i<m;i++){
            temp[row][i] = mat[row][i];
        }

        //shift k times
        for(int i = k;i>0;i--){
            int first = temp[row][0];

            for(int j = 0;j<m-1;j++)temp[row][j] = temp[row][j+1];

            temp[row][m-1] = first; 
        }
    }

    public static void rightShift(int row,int [][] mat, int [][] temp, int k){
        int m = mat[0].length;

        //copy the curr row of mat to temp
        for(int i = 0;i<m;i++){
            temp[row][i] = mat[row][i];
        }

        //shift k times
        for(int i = k;i>0;i--){
            int last = temp[row][m-1];

            for(int j = m-1;j>0;j--)temp[row][j] = temp[row][j-1];

            temp[row][0] = last; 
        }
    }
}