class Solution {
    static int[] par;
    static int[] size;

    static class Edge {
        int u, v, w;

        Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }

    static int find(int x) {
        if (par[x] == x)
            return x;
        return par[x] = find(par[x]);
    }

    static void union(int u, int v) {
        int p_u = find(u);
        int p_v = find(v);

        if (p_u == p_v)
            return;

        if (size[p_u] < size[p_v]) {
            par[p_u] = p_v;
            size[p_v] += size[p_u];
        } else {
            par[p_v] = p_u;
            size[p_u] += size[p_v];
        }
    }

    public int minCostConnectPoints(int[][] points) {
        //here we assume each point [xi, xj]  node
        //generate all possible nodes and make them on the basis
        // of thier distance

        int V = points.length;
        ArrayList<Edge> edges = new ArrayList<>();

        for (int i = 0; i < V - 1; i++) {
            int[] p1 = points[i];
            for (int j = i + 1; j < V; j++) {
                int[] p2 = points[j];

                int dis = Math.abs(p2[0] - p1[0]) + Math.abs(p2[1] - p1[1]);
                Edge e = new Edge(i, j, dis);

                edges.add(e);
            }
        }

        Collections.sort(edges, (a, b) -> Integer.compare(a.w, b.w));
        par = new int[V + 1];
        size = new int[V + 1];

        for (int i = 0; i < V; i++) {
            par[i] = i;
            size[i] = 1;
        }

        //ceheck unitll make a single component 
        int cost = 0;
        for (Edge e : edges) {
            int u = e.u;
            int v = e.v;
            int c = e.w;

            if (find(u) != find(v)) {
                union(u, v);
                cost += c;
            }

        }

        return cost;
    }
}