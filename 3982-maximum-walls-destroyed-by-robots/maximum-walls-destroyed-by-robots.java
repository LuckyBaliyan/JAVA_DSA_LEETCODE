class Solution {
    static int [][] dp;
    static class Pair{
        int first, sec;

        Pair(int first, int sec){
            this.first = first;
            this.sec = sec;
        }

    }

    public static int lowerBound(int[] arr, int target) {
    int left = 0, right = arr.length; 

        while (left < right) {
            int mid = left + (right - left) / 2;
    
            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public static int upperBound(int[] arr, int target) {
        int left = 0, right = arr.length;
    
        while (left < right) {
            int mid = left + (right - left) / 2;
    
            if (arr[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
    
    int countWalls(int [] walls, int l, int r){
       int left = lowerBound(walls, l);
       int right = upperBound(walls, r);

       return right - left;
    }

    int solve(int [] walls, Pair [] roboDist , Pair [] range, int i, int prevDir){
        if(i == roboDist.length)return 0;

        if(dp[i][prevDir] != -1)return dp[i][prevDir];

        int leftStart = range[i].first;

        if(prevDir == 1){
            leftStart = Math.max(leftStart, range[i-1].sec+1);
        }

        int leftTake = countWalls(walls, leftStart, roboDist[i].first) + 
        solve(walls,roboDist,range,i+1,0);

        int rightTake = countWalls(walls, roboDist[i].first, range[i].sec) + 
        solve(walls,roboDist,range,i+1,1);

        return dp[i][prevDir] =  Math.max(leftTake, rightTake);
    }

    public int maxWalls(int[] robots, int[] distance, int[] walls) {
        int n = robots.length;

        dp = new int [n][2];
        for(int [] arr: dp)Arrays.fill(arr, -1);

        Pair [] roboDist = new Pair [n];
        for(int i = 0;i<n;i++){
            roboDist[i] = new Pair(robots[i], distance[i]);
        }

        //Sort according to the nearest robo to the last robo
        Arrays.sort(roboDist, (a,b)-> a.first - b.first);
        Arrays.sort(walls);

        Pair [] range = new Pair [n];

        //prepare the ranges for each robo
        for(int i = 0;i<n;i++){
            int pos = roboDist[i].first;
            int dist = roboDist[i].sec;

            int leftLim = (i == 0) ? 1 : roboDist[i-1].first+1;
            int rightLim = (i == n-1) ?(int) 1e9 : roboDist[i+1].first-1;

            int L = Math.max(pos - dist, leftLim);
            int R = Math.min(pos + dist, rightLim);

            range[i] = new Pair(L,R);
        }

       //prev == 0 i.e previous bullet goes left else right in case of 1
        return solve(walls,roboDist,range, 0, 0);
    }


}