class Solution {
    public int totalWaviness(int num1, int num2) {
        if(num1 <= 100 && num2 <= 100)return 0;

        int w = 0;
        for(int i = num1;i<=num2;i++){
            w += countWave(String.valueOf(i));
        }

        return w;
    }

    public static int countWave(String str){
        int n = str.length();
        int ans = 0;

        for(int i =0;i<n;i++){
            if(i==0 || i==n-1)continue;

            int num1= str.charAt(i+1) - 0;
            int num2 = str.charAt(i) - 0;
            int num3 = str.charAt(i-1) - 0;
            if((num2>num1 && num2>num3) || (num2< num1 && num2<num3))ans++;
        }

        return ans;
    }
}