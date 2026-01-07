class Solution {
    public boolean isAnagram(String s, String t) {
        int [] arr = new int [256];
        int n = s.length();
        int m = t.length();

        if(n!=m)return false;

        for(int i = 0;i<n;i++){
            int val1 = s.charAt(i) - '0';
            int val2 = t.charAt(i) - '0';

            arr[val1]++;
            arr[val2]--;
        }

        for(int i = 0;i<arr.length;i++){
            if(arr[i] != 0)return false;
        }

        return true;
        
    }
}