class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        return solve(landStartTime, landDuration, waterStartTime, waterDuration);
    }

    public static int solve(int [] ls,int [] ld, int [] ws, int [] wd){
        int n = ls.length;
        int m = ws.length;

        int minLand = Integer.MAX_VALUE;
        int minWater = Integer.MAX_VALUE;

        for(int i = 0;i<n;i++){
            minLand = Math.min(minLand, ls[i] + ld[i]);
        }

        for(int i = 0;i<m;i++){
            minWater = Math.min(minWater, ws[i] + wd[i]);
        }

        int res = Integer.MAX_VALUE;

        for(int i = 0;i<m; i++){
            int end = Math.max(minLand, ws[i]) + wd[i];
            res = Math.min(res, end);
        }

        for(int i = 0;i<n;i++){
           int end2 = Math.max(minWater, ls[i]) + ld[i];
           res = Math.min(res, end2);
        }

        return res;
    }
}