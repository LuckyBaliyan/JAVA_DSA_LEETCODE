class Solution {
    static HashMap<Integer,Integer> map;
    static int [][] dp;
    public boolean canCross(int[] stones) {
        //since stones are sorted so we can easily check if after taking
        // the k-1 || k || k+1 is the value exsists or not 
        int n = stones.length;
        map = new HashMap<>();
        dp = new int [n][n];

        //for(int [] a: dp)Arrays.fill(a,-1); 

        for(int i = 0;i<n;i++)map.put(stones[i],i);

        //return solveRec(stones,0,0); --> O(3^n)
    
        // Memoization complexity --> O(n^2) and sc:- O(n^2) + O(n) (recStack)
        //return (solveMemo(stones,0,0) == 1)?true:false;

        return solveTab(stones);
    }

    public static boolean solveTab(int [] arr){
        int n = arr.length;
        
        dp[0][0] = 1; //first stone is reachable always 

        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){

                if(dp[i][j] == 0)continue; //expand only reachable stones

                int first = j - 1;
                int sec = j;
                int third = j + 1;

                if(first >= 0 && first < n && map.containsKey(first + arr[i])){
                    dp[map.get(first + arr[i])][first] = 1;
                }

                if(sec >= 0 && sec < n && map.containsKey(sec  + arr[i])){
                    dp[map.get(sec + arr[i])][sec] = 1;
                }

                if(third >= 0 && third < n && map.containsKey(third + arr[i])){
                    dp[map.get(third + arr[i])][third] = 1;
                }
            }
        }
        
        //check if last stone is reachable from any value of j
        for(int i = 0;i<n;i++){
            if(dp[n-1][i] == 1)return true;
        }

        return false;
    }

    public static int solveMemo(int [] arr,int i,int k){
        int n = arr.length;
        if(i == n-1)return 1;

        if(dp[i][k] != -1)return dp[i][k];

        int first = k - 1;
        int sec = k;
        int third = k + 1;

        //try K - 1;
        if(first > 0 && map.containsKey(first + arr[i])){
            if(solveMemo(arr,map.get(first + arr[i]),first) == 1)
            return dp[i][k] =  1;
        }

        //try k
        if(sec > 0 && map.containsKey(sec + arr[i])){
            if(solveMemo(arr,map.get(sec + arr[i]),sec) == 1)
            return dp[i][k] =  1;
        }

        //try k + 1
        if(third > 0 && map.containsKey(third + arr[i])){
            if(solveMemo(arr,map.get(third + arr[i]),third) == 1)
            return dp[i][k] =  1;
        }

        return dp[i][k] = 0;
    }

    public boolean solveRec(int [] arr,int i,int k){
        int n = arr.length;
        if(i == n-1)return true;

        int first = k - 1;
        int sec = k;
        int third = k + 1;

        //try K - 1;
        if(first > 0 && map.containsKey(first + arr[i])){
            if(solveRec(arr,map.get(first + arr[i]),first))
            return true;
        }

        //try k
        if(sec > 0 && map.containsKey(sec + arr[i])){
            if(solveRec(arr,map.get(sec + arr[i]),sec))
            return true;
        }

        //try k + 1
        if(third > 0 && map.containsKey(third + arr[i])){
            if(solveRec(arr,map.get(third + arr[i]),third))
            return true;
        }

        return false;
    }
}