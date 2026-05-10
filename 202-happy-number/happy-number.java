class Solution {
    public boolean isHappy(int n) {
       HashSet<Integer> st = new HashSet<>();

       while(n != 1 && !st.contains(n)){
            int sum = 0;
            st.add(n);

            while(n > 0){
                int dig = n % 10;
                sum = sum + (dig * dig);

                n /= 10;
            }

            n = sum;
       }

       return n == 1;
    }
}