class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 2 ways either detect a cycle or use topologicalSort via bfs

        int [] visited = new int [numCourses];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i = 0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }

        for(int [] e:prerequisites){
            adj.get(e[0]).add(e[1]);
        }

        for(int i = 0;i<numCourses;i++){
            if(visited[i] == 0){
                if(dfs(adj,visited,i))return false;
            }
        }

        return true;
    }

    public static boolean dfs(ArrayList<ArrayList<Integer>> adj,int [] visited,
    int node){
        visited[node] = 2;

        for(int ne:adj.get(node)){
            if(visited[ne] == 0){
                if(dfs(adj,visited,ne))return true;
            }

            else if (visited[ne] == 2)return true;
        }

        visited[node] = 1;
        return false;
    }
}