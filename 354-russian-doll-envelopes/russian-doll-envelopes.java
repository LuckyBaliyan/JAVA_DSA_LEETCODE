class Solution {
    public static int [][] memo;
    public int maxEnvelopes(int[][] envelopes) {
        return maxDolls(envelopes);
    }

    public static int maxDolls(int [][] arr){
        int n = arr.length;
        int m = arr[0].length;

        // Sort Width wise asc if widths are equal sort height wise desc
        Arrays.sort(arr,(a,b)-> a[0] == b[0]?b[1] - a[1]:a[0] - b[0]);

    
        //Extarcting heights for the LIS

        int [] lis = new int [n];
        for(int i = 0;i<n;i++)lis[i] = arr[i][1];


       // memo = new int [n][n+1];
        //for(int [] a:memo)Arrays.fill(a,-1);

        // return solveMemo(lis,0,-1,memo); --> O(n^2) but gives MLE

        //return solveTab(lis); --> O(n^2) , O(n)
        // Nearly most optimized DP solution but still MLE

        return solveBs(lis);
    }

    public static int solveBs(int [] lis){
        int n = lis.length;

        int [] dp = new int [n];
        dp[0] = lis[0];

        int len = 1;

        for(int i = 1;i<n;i++){
            if(dp[len - 1] < lis[i]){
                dp[len] = lis[i];
                len++;
            }
            else{
                int idx = lb(dp,len-1,lis[i]);
                dp[idx] = lis[i];
            }
        }

        return len;
    }

    public static int lb(int [] dp,int h,int elem){
        int l = 0;
        int ans = 0;

        while(l<=h){
            int mid = l+(h-l)/2;

            if(dp[mid] >= elem){
                ans = mid;
                h = mid - 1;
            }
            else l = mid+1;
        }

        return ans;
    }

    public static int solveTab(int [] lis){
        int n = lis.length;

       // int [][] dp = new int [n+1][n+1];
       int [] curr = new int [n+1];
       int [] next = new int [n+1];



        for(int i = n-1;i>=0;i--){
            for(int prev = -1;prev <= i-1;prev++){
                int take = 0;
                if(prev == -1 || lis[prev] < lis[i]){
                   take = next[i+1]+1;
                }
                int notTake = next[prev+1];

                curr[prev+1] = Math.max(take,notTake);
            }

            next = curr.clone();
        }

        return next[0];
    }

    public static int solveMemo(int [] lis,int i,int prev,int [][] memo){
        int n = lis.length;

        if(i == n)return 0;

        if(memo[i][prev+1] != -1)return memo[i][prev+1];

        int take = 0;
        if(prev == -1 || lis[i] > lis[prev]){
           take = 1 + solveMemo(lis, i+1, i,memo);
        }

        int notTake  = solveMemo(lis, i+1, prev,memo);

        return memo[i][prev+1] = Math.max(take, notTake);
    }

}