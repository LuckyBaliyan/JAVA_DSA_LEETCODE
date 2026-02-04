class Solution {
    long [][] dp;
    public long maxSumTrionic(int[] nums) {
        int n = nums.length;

        //Brute force Solution
        //return solveBrute(nums,n);

        //Rec + Memo Solution Dp O(N)*O(4) ~ O(N)
        dp = new long[n+1][4]; // i --> n and trends --> 0/1/2/3 total 4
        for(long [] arr:dp)Arrays.fill(arr,Long.MIN_VALUE);

        return solveMemo(nums,n,0,0,dp);
    }

    public static long solveMemo(int [] arr,int n,int i,int trend,long [][] dp){
        if(i == n){
            if(trend == 3){
                return 0;
            }
            else return Long.MIN_VALUE;
        }

        if(dp[i][trend] != Long.MIN_VALUE)return dp[i][trend];

        long skip = -(long)1e18;
        long take = -(long)1e18;

        if(trend == 0){
            skip = solveMemo(arr,n,i+1,trend,dp);
        }

        if(trend == 3){
            take = arr[i];
        }

        if(i+1 < n){
            int curr = arr[i];
            int next = arr[i+1];

            if(trend == 0 && next > curr){
                take = Math.max(take,curr + solveMemo(arr,n,i+1,1,dp));
            }
            else if (trend == 1){
                if(next > curr){
                    take = Math.max(take,curr + solveMemo(arr,n,i+1,1,dp));
                }
                else if (next < curr){
                    take = Math.max(take,curr + solveMemo(arr,n,i+1,2,dp));
                }
            }
            else if (trend == 2){
                if(next < curr){
                    take = Math.max(take,curr+solveMemo(arr,n,i+1,2,dp));
                }
                else if(next > curr){
                    take = Math.max(take,curr + solveMemo(arr,n,i+1,3,dp));
                }
            }
            else if(trend == 3 && next > curr){
                take = Math.max(take,curr + solveMemo(arr,n,i+1,3,dp));
            }
        }

        return dp[i][trend] = Math.max(take,skip);
    }

    public static long solveBrute(int [] arr,int n){
        long maxSum = -(long)1e18;
        for(int i = 0;i<n-1;i++){
            for(int j = i+1;j<n;j++){
                if(isTrionic(arr,i,j)){
                   maxSum = Math.max(maxSum,computeSum(arr,i,j));
                }
            }
        }

       return maxSum == -(long)1e18 ? 0 : maxSum;
    }

    public static boolean isTrionic(int [] arr,int start,int end){
        if((end - start + 1) < 4)return false;

        int l = start,p = -1,q = -1,r = -1;

        for(int i = l;i<=end-1;i++){
            if(arr[i] < arr[i+1])continue;
            p = i;
            break;
        }

        if(p <= start)return false;

        for(int i = p;i<=end-1;i++){
            if(arr[i] > arr[i+1])continue;
            q = i;
            break;   
        }

        if(q <= p)return false;

        for(int i = q;i<=end-1;i++){
            if(arr[i] < arr[i+1])continue;
            else{
                r = i;
                break;
            }
        }

        if(r == -1)r = end;
        return q < r && r == end;
    }

    public static long computeSum(int [] arr,int start,int end){
        long localSum = 0;

        for(int i = start;i<=end;i++){
            localSum += arr[i];
        }

        return localSum;
    }
}