class Solution {
    static HashMap<Integer,Integer> map;
    static int [][] dp;
    public boolean canCross(int[] stones) {
        //since stones are sorted so we can easily check if after taking
        // the k-1 || k || k+1 is the value exsists or not 
        int n = stones.length;
        map = new HashMap<>();
        dp = new int [n][n];

        for(int [] a: dp)Arrays.fill(a,-1); 

        for(int i = 0;i<n;i++)map.put(stones[i],i);

        //return solveRec(stones,0,0); --> O(3^n)
        return (solveMemo(stones,0,0) == 1)?true:false;
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