class Solution {
    public int rotatedDigits(int n) {
        int cnt = 0;
        for(int i = 1; i<=n; i++){
            if(isValid(i))cnt++;
        }

        return  cnt;
    }

    public boolean isValid(int num){
        boolean check = false;

        while(num > 0){
            int d = num % 10;
            if(d == 3 || d == 4 || d == 7)return false;
            if(d == 2 || d == 5 || d == 6 || d == 9)check = true;

            num /= 10;
        }

        return check;
    }
}