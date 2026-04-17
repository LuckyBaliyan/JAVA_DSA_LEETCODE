class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        HashSet<String> st = new HashSet<>(wordDict);
        //use a map to avoid rebuilding of same string again from same i
        HashMap<Integer, List<String>> map = new HashMap<>();

        int n = s.length();

        return solve(s,0,n,st,map);
    }

    public List<String> solve(String s, int i, int n, HashSet<String> st,
    HashMap<Integer, List<String>> dp){
        //return already computed String
        if(dp.containsKey(i))return dp.get(i);

        List<String> res = new ArrayList<>();

        if(i == n){
            res.add("");
            return res;
        }

        //cehck every substring from i
        for(int j = i; j<n; j++){
           String prefix = s.substring(i, j+1);
           if(st.contains(prefix)){
                List<String> temp = solve(s, j+1, n, st, dp);
    
                for(String str: temp){
                    if(str.equals("")){
                        res.add(prefix);
                    }
                    else{
                        res.add(prefix + " " + str);
                    }
                }
           }
        }
        
        dp.put(i, res);
        return res;
    }
}