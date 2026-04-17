class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        HashSet<String> st = new HashSet<>(wordDict);
        int n = s.length();

        return solve(s,0,n,st);
    }

    public List<String> solve(String s, int i, int n, HashSet<String> st){
        List<String> res = new ArrayList<>();

        if(i == n){
            res.add("");
            return res;
        }

        //cehck every substring from i
        for(int j = i; j<n; j++){
           String prefix = s.substring(i, j+1);
           if(st.contains(prefix)){
                List<String> temp = solve(s, j+1, n, st);
    
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

        return res;
    }
}