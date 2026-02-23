class Solution {
    public boolean hasAllCodes(String s, int k) {
        HashSet<String> hs = new HashSet<>();
        int n = s.length();

        //first generate and put all the substrings of length 
        // k to set for future comparison with all bs of len k
        for(int i = 0;i<=n - k;i++){
           hs.add(s.substring(i,i + k));
        }

        //after putting in hs check if every k length bs is in hs or not
        for(int i = 0;i<(int) Math.pow(2,k);i++){
            String currBs = Integer.toBinaryString(i);
            while(currBs.length() < k)currBs = "0" + currBs;
            if(!hs.contains(currBs))return false;
        }

        return true;
    }
}