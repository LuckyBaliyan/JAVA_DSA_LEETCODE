class Solution {
    //set up the plane according to question
    static char [][] keyBoard = {
        {'A','B','C','D','E','F'},
        {'G','H','I','J','K','L'},
        {'M','N','O','P','Q','R'},
        {'S','T','U','V','W','X'},
        {'Y','Z','$','$','$','$'}
    };

    //adding memoization optimization
    static int [][][] dp;
    
    //absoulte distance formula based function
    static int getDistance(char a, char b){
       int x1 = 0;
       int x2 = 0;

       int y1 = 0;
       int y2 = 0;

       for(int i = 0;i<5;i++){
        for(int j = 0;j<6;j++){
            if(keyBoard[i][j] == a){
                x1 = i;
                y1 = j;
            }
            if (keyBoard[i][j] == b){
                x2 = i;
                y2 = j;
            }
        }
       }

       //absoulte distance formula
       return Math.abs(x2 - x1) + Math.abs(y2 - y1);
    }
   
    //get effective dp index for memo as we can't pass f1 f2 both are char
    static int getIndex(char c){
       if(c == '$') return 26;
       return c - 'A';
    }

    public int minimumDistance(String word) {
        int n = word.length();
        dp = new int [n][27][27];

        for(int i = 0;i<dp.length;i++){
            for(int j = 0; j < 27; j++){
                for(int k = 0; k < 27; k++){
                    dp[i][j][k] = -1;
                }
            }
        }

        return solve(word,0,n,'$','$');
    }

    public static int solve(String word, int i, int n, char f1, char f2){
        //handlinhg bounds 
        if(i == n)return 0;

        if(dp[i][getIndex(f1)][getIndex(f2)] != -1)
        return dp[i][getIndex(f1)][getIndex(f2)];

        int movef1 = 0;
        int movef2 = 0;

        char curr = word.charAt(i);

        //start of the typing from fingure 1
        if(f1 == '$'){
            movef1 = solve(word,i+1,n,curr,f2);
        }
        else{
            movef1 = getDistance(curr,f1) + solve(word,i+1,n,curr,f2);
        }

        //start of the typing from fingure 2
        if(f2 == '$'){
            movef2 = solve(word,i+1,n,f1,curr);
        }
        else{
            movef2 = getDistance(curr,f2) + solve(word,i+1,n,f1,curr);
        }


        return dp[i][getIndex(f1)][getIndex(f2)] = Math.min(movef1, movef2);
    }
}