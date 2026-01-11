class Solution {
    public int residuePrefixes(String s) {
        int n = s.length();
        if(n==0)return 0;
        
        HashSet<Integer> st = new HashSet<>();

        int len = 0;
        int ans = 0;

        for(int i =0;i<n;i++){
            int c = s.charAt(i) - 'a';
            st.add(c);
            int distinct = st.size();

            len = i + 1;
            if(distinct == len % 3)ans++;
        }

        return ans;
    }
}