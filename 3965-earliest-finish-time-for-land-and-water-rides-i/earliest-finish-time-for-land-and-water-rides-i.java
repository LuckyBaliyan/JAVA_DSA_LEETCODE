class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        return solveBrute(landStartTime, landDuration, waterStartTime, waterDuration);
    }

    public static int solveBrute(int [] ls, int [] ld, int [] ws, int [] wd){
        int n = ls.length;
        int m = ws.length;

        //start with landStaring plan
        // --> either was < currTime 
        // --> either was >  currTime

        int res = Integer.MAX_VALUE;
        
        for(int i = 0;i<n;i++){
            int currTime = ls[i] + ld[i];

           for(int j = 0;j<m;j++){
              if(currTime >= ws[j]){
                int endTime = currTime + wd[j];
                res = Math.min(res, endTime);
              }
              else{
                res = Math.min(res, ws[j] + wd[j]);
              }
           }
        }

        //Now start with diffrent plan i.e start with water
        for(int i = 0; i<m; i++){
            int currTime2 = ws[i] + wd[i];

            for(int j = 0;j<n; j++){
                if(currTime2 >= ls[j]){
                    int endTime2 = currTime2 + ld[j];
                    res = Math.min(res, endTime2);
                }
                else{
                    res = Math.min(res, ls[j] + ld[j]);
                }
            }
        }

        return res;
    }
}