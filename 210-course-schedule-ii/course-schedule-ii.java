class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int v = numCourses;
        int e = prerequisites.length;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i = 0;i<v;i++){
            adj.add(new ArrayList<>());
        }

        for(int [] p:prerequisites){
            // we have to take b first and a second A.T.Q 
            //adj.get(p[0]).add(p[1]);

            //as we can take course ai after bi i.e b(u) --> a(v) acc. to topoSort
            adj.get(p[1]).add(p[0]);
        }

        int [] inDegree = new int [v];
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> res = new ArrayList<>();

       // calculating the inDegree of all the nodes
       for(int i = 0;i<v;i++){
        for(int ne:adj.get(i)){
            /*if(inDegree[ne] == 0) initially calculate for all*/
            inDegree[ne]++;
        }
       }

       // adding the source or nodes having 0 indegree in the qeueue
       for(int i = 0;i<v;i++){
        if(inDegree[i] == 0)q.offer(i);
       }

       bfs(adj,inDegree,q,res);

       if(res.size() != v)return new int [] {};

       int size = res.size();
       int [] ans = new int [size];
       for(int i = 0;i<size;i++)ans[i] = res.get(i);

       return ans;
    }

    public static void bfs(ArrayList<ArrayList<Integer>> adj,int [] inDegree,
    Queue<Integer> q,ArrayList<Integer> res){
        while(!q.isEmpty()){
            int node = q.poll();
            res.add(node);

            for(int ne:adj.get(node)){
                inDegree[ne]--;

                if(inDegree[ne] == 0){
                    q.offer(ne);
                }
            }
        }
    }

}