class Solution {
    public boolean isDigitorialPermutation(int n) {
       int temp = n;
       int sum  = 0;

       //HashMap<Integer,Integer> map = new HashMap<>();

       while(temp > 0){
        int dig = temp % 10;
        temp /= 10;
       // map.put(dig,fac(dig));
       sum += fac(dig);
       }

      /* int temp2 = n;
       while(temp2 > 0){
        int dig2 = temp2 % 10;
        sum += map.get(dig2);
        temp2 /= 10;
       }*/

       return isDigitorial(sum,n);
    }

    public static int fac(int n){
        if(n <= 1)return 1;
        int pro = 1;

        for(int i = n;i>=2;i--)pro *=i;
        return pro;
    }

    public static boolean isDigitorial(int num , int n){
        int [] fac = new int [10];

        while(num > 0){
            fac[num%10]++;
            num = num/10;
        }

        while(n > 0){
            fac[n % 10]--;
            n = n/10;
        }

        for(int i:fac){
            if(i != 0)return false;
        }

        return true;
    }
}