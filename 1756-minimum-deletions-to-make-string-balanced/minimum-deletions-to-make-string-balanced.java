class Solution {
    static int [][] dp;
    public int minimumDeletions(String s) {
        //Method 1 --> O(N), O(1)
        int bs = 0;
        int minCost = 0;

        for(char ch:s.toCharArray()){
            if(ch == 'b')bs++;
            if(bs > 0 && ch == 'a')minCost++;

            minCost = Math.min(minCost,bs);
        }

        return minCost;
        
        /* Methiod 2 --> O(N) , O(N)
        Stack<Character> st = new Stack<>();
        int deletions = 0;

        for(char ch : s.toCharArray()){
            if(ch == 'b'){
                st.push('b');
            } else {
                if(!st.isEmpty() && st.peek() == 'b'){
                    st.pop();       
                    deletions++;    
                } else {
                    st.push('a');
                }
            }
        }
        return deletions;
        */
        
        // Method 3 --> O(2^N), O(N) --> TLE
        //return solveRec(s,0,0);
        
        /*int n = s.length();
        dp = new int [n][n]; 
        for(int [] arr:dp)Arrays.fill(arr,-1);
        */

        //O(N^2), O(N^2)  -> MLE
       // return  solveMemo(s,0,0,dp);
    }

    public static int solveRec(String s,int bcount,int i){
        int n = s.length();
        
        if(i == n)return 0;
        int ans = Integer.MAX_VALUE;

        if(s.charAt(i) == 'a'){
            if(bcount == 0){
                ans = solveRec(s,0,i+1);
            }
            else{
                ans = Math.min(
                    1 + solveRec(s,bcount,i+1), // delet 'a' with a cost
                    bcount + solveRec(s,0,i+1) // replace 'b'
                );
            }
        }
        else{
            ans = Math.min(
                solveRec(s,bcount + 1,i+1),
                1 + solveRec(s,bcount,i+1)
            );
        }

        return ans;
    }

    public static int solveMemo(String s,int bcount,int i,int [][] dp){
        int n = s.length();
        
        if(i == n)return 0;
        int ans = Integer.MAX_VALUE;

        if(dp[i][bcount] != -1)return dp[i][bcount];

        if(s.charAt(i) == 'a'){
            if(bcount == 0){
                ans = solveMemo(s,0,i+1,dp);
            }
            else{
                ans = Math.min(
                    1 + solveMemo(s,bcount,i+1,dp), // delet 'a' with a cost
                    bcount + solveMemo(s,0,i+1,dp) // replace 'b'
                );
            }
        }
        else{
            ans = Math.min(
                solveMemo(s,bcount + 1,i+1,dp),
                1 + solveMemo(s,bcount,i+1,dp)
            );
        }

        return dp[i][bcount] = ans;
    }
}