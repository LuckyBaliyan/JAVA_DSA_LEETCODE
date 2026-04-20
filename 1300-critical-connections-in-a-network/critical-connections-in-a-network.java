import java.util.*;

class Solution {

    int timer = 0;

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        
        List<List<Integer>> result = new ArrayList<>();
        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for(List<Integer> edge : connections){
            int u = edge.get(0);
            int v = edge.get(1);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int[] tin = new int[n];
        int[] low = new int[n];
        boolean[] visited = new boolean[n];

        dfs(adj, 0, -1, tin, low, visited, result);

        return result;
    }

    private void dfs(List<List<Integer>> graph, int node, int parent,
                     int[] tin, int[] low, boolean[] visited,
                     List<List<Integer>> result) {

        visited[node] = true;
        tin[node] = low[node] = timer++;

        for (int ne : graph.get(node)) {

            if (ne == parent) continue;

            if (!visited[ne]) {
                dfs(graph, ne, node, tin, low, visited, result);

                //low update
                low[node] = Math.min(low[node], low[ne]);

                //bridge condition
                if (low[ne] > tin[node]) {
                    result.add(Arrays.asList(node, ne));
                }

            } else {
                //back edge
                low[node] = Math.min(low[node], tin[ne]);
            }
        }
    }
}