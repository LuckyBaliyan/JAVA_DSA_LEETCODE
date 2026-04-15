class Solution {
    static int [] memo;
    public int[] countBits(int n) {
        int [] ans = new int [n + 1];

        memo = new int [n + 1];
        Arrays.fill(memo, -1);

        for(int i = 0; i<= n; i++){
            ans[i] = solve(i);
        } 

        return ans;
    }

    // TC :- O(log N)
    public static int solve(int num){
        //BaseCase required one's to make 0 or 1
        if(num == 0)return 0;
        if(num == 1)return 1; 

        if(memo[num] != -1)return memo[num];

        if(num % 2 == 0)return memo[num] = solve(num / 2);
        else return memo[num] = 1 + solve(num / 2);
    }
}