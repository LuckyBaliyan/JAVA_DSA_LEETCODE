class Solution {
    public boolean isAnagram(String s, String t) {
        int [] arr = new int [26];
        int n = s.length();
        int m = t.length();

        if(n!=m)return false;

        for(int i = 0;i<n;i++){
            int val1 = s.charAt(i) - 'a';
            int val2 = t.charAt(i) - 'a';

            arr[val1]++;
            arr[val2]--;
        }

        for(int i = 0;i<arr.length;i++){
            if(arr[i] != 0)return false;
        }

        return true;
    

        //return brute(s,t);
        
    }

/*
    public static boolean brute(String s,String t){
        int n = s.length();
        int m = t.length();

        if(n!=m)return false;

        if(s.equals(t))return true;

        for(int i = 0;i<n;i++){
            char ch =  s.charAt(i);

            int c1 = 0;
            int c2 = 0;

            for(char c:s.toCharArray()){
                if(c == ch)c1++;
            }

            
            for(char c:t.toCharArray()){
                if(c == ch)c2++;
            }

            if(c1 != c2)return false;
        }

        return true;
    }
    */
}