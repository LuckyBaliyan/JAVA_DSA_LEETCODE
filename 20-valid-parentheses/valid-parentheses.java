class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        Map<Character, Character> mapping = new HashMap<>();
        mapping.put(')', '(');
        mapping.put('}', '{');
        mapping.put(']', '[');

        for(char ch:s.toCharArray()){
            if(mapping.containsValue(ch)){
                st.push(ch);
            }
            else if(mapping.containsKey(ch)){
                if(st.isEmpty() || mapping.get(ch) != st.pop())return false;
            } 
        }

        return st.isEmpty();
    }
}