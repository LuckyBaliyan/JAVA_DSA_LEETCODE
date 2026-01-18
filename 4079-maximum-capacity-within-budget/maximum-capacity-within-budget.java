class Solution {
    public int maxCapacity(int[] costs, int[] capacity, int budget) {
        //return bs(costs,capacity,budget);
        return dp(costs,capacity,budget);
    }

    public static int dp(int [] costs,int [] capacity,int budget){
        int n = costs.length;

        int [][] machines = new int[n][2];

        for(int i = 0;i<n;i++){
            machines[i][0] = costs[i];
            machines[i][1] = capacity[i];
        }

        Arrays.sort(machines,(a,b)->a[0] - b[0]);

        int ans = 0;
        int l =0;
        int r = n-1;

        int [] maxCap = new int[n];
        maxCap[0] = machines[0][1];

        for(int i = 1;i<n;i++){
            maxCap[i] = Math.max(maxCap[i-1],machines[i][1]);
        }

        //int ans = 0;
        

        for(int i = 0;i<n;i++){
            if(machines[i][0] < budget){
                ans = Math.max(ans,machines[i][1]);
            }
        }

        for(int i = 1;i<n;i++){
            int rem = budget - machines[i][0] - 1;

            if(rem <= 0)continue;

            int idx = bs2(machines,0,i-1,rem);

            if(idx != -1){
                ans = Math.max(ans,machines[i][1] + maxCap[idx]);
            }
        }

        return ans;
    }

    public static int bs2(int [][] arr,int l,int r,int t){
        int res = -1;
        while(l<=r){
            int mid = (l+r)/2;
            if(arr[mid][0] <= t){
                res = mid;
                l = mid + 1;
            }
            else r = mid - 1;
        }

        return res;
    }

    // n^2 log n
    public static int bs(int [] costs,int [] capacity,int budget){
          int n = costs.length;

        int max1 = 0;
        int max2 = 0;

        for(int c:capacity){
            if(c>=max1){
                max2 = max1;
                max1 = c;
            }
            else if ( c > max2)max2 = c;
        }

        int l = 0;
        int h = max1 + max2;

        int ans = 0;

        while(l<=h){
            int mid = l+(h-l)/2;

            if(isValid(mid,costs,capacity,budget)){
                ans = mid;
                l = mid + 1;
            }
            else h = mid - 1;
        }

        return ans;
    }

    public static boolean isValid(int mid,int [] costs,int [] capacity,int budget){
        int n = capacity.length;

        for(int i = 0;i<n;i++){
            if(capacity[i] >= mid && costs[i] < budget)return true;
        }

        for(int i = 0;i<n;i++){
            for(int j = i+1;j<n;j++){
                if(capacity[i] + capacity[j] >= mid &&
                  costs[i] + costs[j] < budget)return true;
            }
        }

        return false;
    }
}