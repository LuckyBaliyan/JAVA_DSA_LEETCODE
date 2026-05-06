/**
 * @param {number[][]} matrix
 * @return {void} Do not return anything, modify matrix in-place instead.
 */
var rotate = function(matrix) {
    let m = matrix.length;
    let n = matrix[0].length;

    //first transpose inPalce i.e swap above diagonal elems
    for(let i = 0; i<m; i++){
        for(let j = i+1; j<n; j++){
            let temp = matrix[i][j];
            matrix[i][j] = matrix[j][i];
            
            matrix[j][i] = temp;
        }
    }

    //Now reverse each row
    for(let i = 0; i<m; i++){
        reverse(matrix,i,n);
    }
};

var reverse  = (matrix,row,n)=>{
    let l = 0;
    let r = n-1;

    while(l < r){
        let temp = matrix[row][l];
        matrix[row][l] = matrix[row][r];
        matrix[row][r] = temp;

        l++;
        r--; 
    }
}