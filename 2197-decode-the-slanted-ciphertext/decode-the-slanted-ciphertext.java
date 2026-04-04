class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        int m = encodedText.length();
       
        //from clear observation it's clear that we can divide the totaLength
        //with rows given in order to divide the string in matrix
        int col = m / rows;
        StringBuilder decoded = new StringBuilder();

        //Make a 2d matrix of 100 * m  (at max) to track the character's of string
        char [][] arr = new char[rows][col];
        
        int idx = 0;
        for(int i = 0;i<rows;i++){
           for(int j = 0;j<col;j++){
            arr[i][j] = encodedText.charAt(idx++);
           }
        }


        for(int i = 0;i<col;i++){
            int j = 0; int k = i;
            while(j< rows && k < col){
                decoded.append(arr[j][k]);

                j++;
                k++;
            }
        }

        return decoded.toString().replaceAll("\\s+$", "");
    }
}