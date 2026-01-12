class Solution {
    List<Integer> [][] dp;
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);  // --> n log n
        //List<Integer> res = new ArrayList<>();
        int n = nums.length;

        dp = new ArrayList[n][n+1];
        //return solve(nums,0,-1);

        return solveMemo(nums,0,-1);
    }

   // Plain recursive solution --> O(2^n)
    public static List<Integer> solve(int [] arr,int i,int prev){
        int n = arr.length;

        if(i == n)return new ArrayList<>();

        List<Integer> take = new ArrayList<>();
        if(prev == -1 || (arr[i] %arr[prev] == 0) || (arr[prev] % arr[i] == 0)){
            take = solve(arr,i+1,i);
            take = new ArrayList<>(take);
            take.add(arr[i]);
        }

        List<Integer> skip = solve(arr,i+1,prev);

        return take.size() > skip.size() ? take:skip;
    }

    public List<Integer> solveMemo(int [] arr,int i,int prev){
        int n = arr.length;

        if(i == n)return new ArrayList<>();

        if(dp[i][prev+1] != null)return dp[i][prev+1];

        List<Integer> take = new ArrayList<>();
        if(prev == -1 || (arr[i] %arr[prev] == 0) || (arr[prev] % arr[i] == 0)){
            take = solveMemo(arr,i+1,i);
            take = new ArrayList<>(take);
            take.add(arr[i]);
        }

        List<Integer> skip = solveMemo(arr,i+1,prev);

        return dp[i][prev + 1] =  take.size() > skip.size() ? take:skip;
    }
}