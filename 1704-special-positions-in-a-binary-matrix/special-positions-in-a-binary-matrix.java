class Solution {
    public int numSpecial(int[][] mat) {
        //TC --> O(N * M) * O(N + M) to O(N^3) 
        //SC --> O(1)
       //return approach1(mat);

       //TC --> O(N * M) SC --> O(N + M)
       return approach2(mat);
    }

    public int approach2(int [][] mat){
        int m = mat.length;
        int n = mat[0].length;

        int [] rowCount = new int [m];
        int [] colCount = new int [n];

        int specials = 0;

        //scan one's and store them
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(mat[i][j] == 1){
                    rowCount[i]++;
                    colCount[j]++;
                }
            }
        }

        //count after verfiying 
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(mat[i][j] == 1){
                    if(rowCount[i] == 1 && colCount[j] == 1){
                        specials++;
                    }
                }
            }
        }

        return specials;
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