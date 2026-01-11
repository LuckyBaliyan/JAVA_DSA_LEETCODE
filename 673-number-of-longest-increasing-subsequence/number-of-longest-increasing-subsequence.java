class Solution {
    public int findNumberOfLIS(int[] nums) {
        return solveTab(nums);
    }

    public static int solveTab(int [] arr){
        int n = arr.length;

        int [] curr = new int [n+1];
        int [] next = new int [n+1];
        int [] currCnt = new int [n+1];
        int [] nextCnt = new int [n+1];
       

        for(int j = 0;j<=n;j++)nextCnt[j] = 1;

        for(int i = n-1;i>=0;i--){
            for(int j = -1;j<=i-1;j++){
                int take = 0,takeCnt = 0;
                if(j == -1 || arr[i] > arr[j]){
                    take = 1 + next[i+1];
                    takeCnt = nextCnt[i+1];
                }

                int notTake = next[j+1];
                int notTakeCnt = nextCnt[j+1];

                curr[j+1] = Math.max(take, notTake);

                if(take > notTake){
                    currCnt[j+1] = takeCnt;
                }
                else if(take < notTake){
                    currCnt[j+1] = notTakeCnt;
                }
                else currCnt[j+1] = takeCnt + notTakeCnt;
            }

            next = curr.clone();
            nextCnt = currCnt.clone();
        }

        return nextCnt[0];
    }
}