class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {

        List<Integer>[] redAdj = new ArrayList[n];
        List<Integer>[] blueAdj = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            redAdj[i] = new ArrayList<>();
            blueAdj[i] = new ArrayList<>();
        }

        for (int[] e : redEdges) {
            redAdj[e[0]].add(e[1]);
        }

        for (int[] e : blueEdges) {
            blueAdj[e[0]].add(e[1]);
        }

        int[] ans = new int[n];
        Arrays.fill(ans, -1);

        // visited[node][color]
        boolean[][] visited = new boolean[n][2];

        Queue<int[]> q = new LinkedList<>();

        // start with both colors
        q.offer(new int[]{0, 0, 0}); // last color RED
        q.offer(new int[]{0, 1, 0}); // last color BLUE

        visited[0][0] = true;
        visited[0][1] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int node = cur[0];
            int color = cur[1];
            int dist = cur[2];

            if (ans[node] == -1) {
                ans[node] = dist;
            }

            // switch color
            if (color == 0) {
                // last was RED → go BLUE
                for (int nei : blueAdj[node]) {
                    if (!visited[nei][1]) {
                        visited[nei][1] = true;
                        q.offer(new int[]{nei, 1, dist + 1});
                    }
                }
            } else {
                // last was BLUE → go RED
                for (int nei : redAdj[node]) {
                    if (!visited[nei][0]) {
                        visited[nei][0] = true;
                        q.offer(new int[]{nei, 0, dist + 1});
                    }
                }
            }
        }

        return ans;
    }
}