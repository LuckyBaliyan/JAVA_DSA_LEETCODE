class Solution {
    public int largestPrime(int n) {
        if(n==1)return 0;
        if(n==2)return n;

        int sum = 0;
        int res = 0;
        for(int i = 1;i<n;i++){
            if(isPrime(i)){
                sum+=i;

                if(sum > n)break;

                if(isPrime(sum)){
                    res = sum;
                }
            }
        }

        return res;
    }

    public static boolean isPrime(int num){
        if(num == 2)return true;
        if(num == 1)return false;
        for(int i = 2;i*i<=num;i++){
            if(num % i == 0)return false;
        }
        return true;
    }
}