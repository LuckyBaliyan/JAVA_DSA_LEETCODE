class Solution {
    public int[] countBits(int n) {
        int [] ans = new int [n + 1];

        for(int i = 0; i<= n; i++){
            ans[i] = solve(i);
        } 

        return ans;
    }

    public static int solve(int num){
        //BaseCase required one's to make 0 or 1
        if(num == 0)return 0;
        if(num == 1)return 1; 

        if(num % 2 == 0)return solve(num / 2);
        else return 1 + solve(num / 2);
    }
}