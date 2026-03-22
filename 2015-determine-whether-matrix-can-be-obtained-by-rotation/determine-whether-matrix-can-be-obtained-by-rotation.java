class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {
        int n = mat.length;
        int m = mat[0].length;
        boolean flag = true;

        //at max 4 time's a matrix can be rotated 90 deg 360 deg / 90 deg = 4
        for(int k = 0; k < 4; k++){
            //reset to true after every false
            flag = true;

           //Transpose T' only swap above diagonal elements
           for(int i = 0;i<n;i++){
            for(int j = i+1;j<m;j++){
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
           }

           //reverse row wise becuase 90deg rotation = Transpose + revrse (rows)
           for(int i = 0;i<n;i++)rev(mat,i,0,m-1);

           //finally check the elements with target
           for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(mat[i][j] != target[i][j])flag = false;
            }
           }

           if(flag)return true;
        }

        return false;
    }

    public static void rev(int [][] mat,int row,int l,int r){
        while(l<=r){
            int temp = mat[row][l];
            mat[row][l] = mat[row][r];
            mat[row][r] = temp;

            l++;
            r--;
        }
    }
}