class Solution {
    static int [] dp;
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;

        int [][] jobs = new int [n][3];
        dp = new int [n];

        Arrays.fill(dp, -1);

        for(int i = 0; i<n; i++){
            jobs[i] = new int [] {startTime[i], endTime[i], profit[i]};
        }

        Arrays.sort(jobs, (a,b)->Integer.compare(a[0], b[0]));

        return solve(jobs, n, 0);
    }

    public static int solve(int [][] arr, int n, int i){
        if(i >= n)return 0;
        if(dp[i] != -1)return dp[i];

        int skip = solve(arr, n, i+1);
        int next = lb(i,arr,n);

        int take = arr[i][2] + solve(arr, n, next);

        return dp[i] = Math.max(take, skip);
    }

    public static int lb(int i, int [][] arr, int n){
        int l= i+1;
        int r = n - 1;

        int ans = n;

        while(l<=r){
            int mid = l + (r-l)/2;

            if(arr[mid][0] >= arr[i][1]){
                ans = mid;
                r = mid - 1;
            }
            else {
                l = mid + 1;
            }
        }
        
        return ans;
    }
}