class Solution {
    static Queue<int []> q;
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;

        q = new LinkedList<>();
        int [] color = new int [n+1];

        for(int i = 0;i<n;i++){
            if(color[i] == 0){
                if(!bfs(graph,color,i))return false;
            }
        }

        return true;
    }

    public static boolean bfs(int [][] graph,int [] color,int node){
        color[node] = 1;
        q.add(new int [] {node,1});

        while(!q.isEmpty()){
            int [] curr = q.poll();
            int parent  = curr[0];
            int c = curr[1];

            for(int ne:graph[parent]){
                if(color[ne] == 0){
                    color[ne] = c==1?2:1;
                    q.offer(new int [] {ne,color[ne]});
                }
                else if (color[ne] == c)return false;
            }
        }

        return true;
    }
}