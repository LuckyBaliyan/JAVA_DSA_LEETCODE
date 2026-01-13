class Solution {
    public int longestStrChain(String[] words) {

        //O(n log n)
        Arrays.sort(words,
        (a,b)-> a.length() - b.length()
        );

        int n = words.length;

        int [][] dp = new int [n][n+1];

        for(int [] arr:dp)Arrays.fill(arr,-1);

        return solve(words,0,-1,dp);
    }

    public static int solve(String [] arr,int i,int prev,int [][] dp){
        int n = arr.length;

        if(i==n)return 0;

        if(dp[i][prev + 1] != -1)return dp[i][prev + 1];

        int take = 0;
        if(prev == -1 || (arr[i].length() - arr[prev].length() == 1 &&    isValid(arr[i],arr[prev]))){
          take = 1 + solve(arr,i+1,i,dp);
        }

        int notTake = solve(arr,i+1,prev,dp);

        return dp[i][prev + 1] = Math.max(take,notTake);
    }

    static boolean isValid(String s,String t){
        int n1 = s.length();

        int i = 0;
        int j = 0;
        while(i < n1){
            if(j < t.length() && s.charAt(i) == t.charAt(j)){
            i++;
            j++;
            }
            else i++;
        }

        return j == t.length();
    }
}