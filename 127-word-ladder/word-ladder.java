//Method 2 --> O(N^2 * 26)
class Solution{
    public int ladderLength(String beginWord,String endWord, List<String> wordList){
        HashSet<String> st = new HashSet<>();

        for(String w:wordList)st.add(w);

        if(!st.contains(endWord))return 0;
        return bfs(beginWord,wordList,endWord,st);
    }

    public static int bfs(String start,List<String> wordList,String end,      HashSet<String> st){
        Queue<String> q = new LinkedList<>();
        q.add(start);
        st.remove(start);
        int cnt =  1;

        while(!q.isEmpty()){
            int size = q.size();

            for(int i = 0;i<size;i++){
                String word = q.poll();

                if(word.equals(end))return cnt;
                char [] w = word.toCharArray();

                for(int j = 0;j<w.length;j++){
                    char original = w[j];

                    for(char ch = 'a';ch<='z';ch++){
                        w[j] = ch;

                        String newWord = new String(w);

                        if(st.contains(newWord)){
                            q.add(newWord);
                            st.remove(newWord);
                        }
                    }

                    w[j] = original; //Restore the original word back;
                }
            }

            cnt++;
        }

        return 0;
    }
}
//Method 1 -- > O(N^2*M)
/*class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(beginWord)){
            wordList.add(beginWord);
        }
        
        int n = wordList.size();

        if(!wordList.contains(endWord))return 0;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i = 0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0;i<n-1;i++){
          for(int j = i+1;j<n;j++){
            if(check(wordList.get(i),wordList.get(j))){
                adj.get(i).add(j);
                adj.get(j).add(i);
            }
          }
        }

        boolean [] visited = new boolean [n];
        Queue<Integer> q = new LinkedList<>();

        int start = wordList.indexOf(beginWord);
        int end = wordList.indexOf(endWord);

        return bfs(adj,visited,start,end,q);
    }

    public static int bfs(ArrayList<ArrayList<Integer>> adj,boolean [] visited,int 
    start,int end,Queue<Integer> q){
        visited[start] = true;
        q.offer(start);
        int cnt = 1;

        while(!q.isEmpty()){
            int n = q.size();

            for(int i = 0;i<n;i++){
                int node = q.poll();

                if(node == end)return cnt;

                for(int ne:adj.get(node)){
                    if(!visited[ne]){
                        visited[ne] = true;
                        q.offer(ne);
                    }
                }

            }
            cnt++;
        }

        return 0;
    }

    public static boolean check(String a,String b){
        int cnt = 0;
        for(int i  = 0;i<a.length();i++){
            if(a.charAt(i) != b.charAt(i))cnt++;

            if(cnt > 1)return false;
        }

        return cnt == 1;
    }
}
*/