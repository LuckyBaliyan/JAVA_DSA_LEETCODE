class Solution {
   
    public int longestBalanced(String s) {
        //Brute force --> O(N^2 * 26) O(26) TLE
       //return solveBrute(s);

       return solveMap(s);
    }

    public static int solveMap(String s){
        int n = s.length();
        int maxLen = 0;

       //case 1:- if answer because of majority continue a's
        int cnt = 1;
        for(int i = 1;i<n;i++){
            if(s.charAt(i) == s.charAt(i-1))cnt++;
            else{
                maxLen = Math.max(maxLen,cnt);
                cnt = 1;
            }
        }

        maxLen = Math.max(maxLen,cnt);

        //CASE 2:- if answer because of 2 a's and 2 b's or 2 b's and 2 c's ---
        // we have to check for each pair 
        maxLen = Math.max(maxLen,helper(s,'a','b'));
        maxLen = Math.max(maxLen,helper(s,'a','c'));
        maxLen = Math.max(maxLen,helper(s,'b','c'));

        //CASE 3:-  check for all 3 a,b,c
        int cntA = 0;
        int cntB = 0;
        int cntC = 0;
        HashMap<String,Integer> diffMap = new HashMap<>();
        diffMap.put("0-0",-1);

        for(int i = 0;i<n;i++){
            char ch = s.charAt(i);

            if(ch == 'a')cntA++;
            else if (ch == 'b')cntB++;
            else cntC++;


            if(cntA == cntB && cntB == cntC && cntA == cntC){
                maxLen = Math.max(maxLen,cntA + cntB + cntC);
            }

            int diffAb = cntA - cntB;
            int diffAc = cntA - cntC;

            String newDiff = diffAb +"-"+ diffAc;
            if(diffMap.containsKey(newDiff)){
                maxLen = Math.max(maxLen,(i - diffMap.get(newDiff)));
            }
            else diffMap.put(newDiff,i);
        }

        return maxLen;
    }

    public static int helper(String s,char first,char sec){
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        int cnt1 = 0;
        int cnt2 = 0;
        int max = 0;

        for(int i = 0;i<s.length();i++){
           char ch = s.charAt(i);

           if(ch != first && ch != sec){
            map = new HashMap<>();
            map.put(0,i); // inorder to reinitialize;
            cnt1 = 0;
            cnt2 = 0;
            continue;
           }

           if(ch == first)cnt1++;
           else if (ch == sec)cnt2++;

           if(cnt1 == cnt2)max = Math.max(max,cnt1 + cnt2);

           int diff = cnt1 - cnt2;
           if(map.containsKey(diff)){
            max = Math.max(max,(i - map.get(diff)));
           }
           else{
            map.put(diff,i);
           }
        }

        return max;
    }

/*
    public static int solveBrute(String s){
        int n = s.length();
        int maxLen = 0;

        for(int i = 0;i<n;i++){
            HashMap<Character,Integer> map = new HashMap<>();
            for(int j = i;j<n;j++){
                char ch = s.charAt(j);
                map.put(ch,map.getOrDefault(ch,0)+1);

                if(check(map))maxLen = Math.max(maxLen,(j - i)+1);
            }
        }

        return maxLen;
    }

    public static boolean check(HashMap<Character,Integer> map){
        int freq = -1;

        for(int val : map.values()){
            if(freq == -1)freq = val;

            if(freq != val)return false;
        }
        return true;
    }
    */
}