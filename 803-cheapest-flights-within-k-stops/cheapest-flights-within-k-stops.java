class Solution {
    static class Node{
        int v, w, s;
        Node(int v, int w, int s){
            this.v = v;
            this.w = w;
            this.s = s;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<Node>> adj = new ArrayList<>();

        for(int i = 0; i<=n; i++)adj.add(new ArrayList<>());

        for(int [] f : flights){
            adj.get(f[0]).add(new Node(f[1], f[2], 0));
        }

        PriorityQueue<Node> pq =
        new PriorityQueue<>((a,b)->Integer.compare(a.w, b.w));

        int [][] steps = new int [n][k+2];
        for(int [] s : steps)Arrays.fill(s, Integer.MAX_VALUE);

        steps[src][0] = 0;
        pq.offer(new Node(src, 0, 0)); //maximum stops allowed

        while(!pq.isEmpty()){
            Node curr = pq.poll();
            int d = curr.w;

            if(curr.v == dst)return curr.w;

           if(curr.s <= k){
                for(Node ne : adj.get(curr.v)){
                    int v = ne.v;
                    int cost = d + ne.w;

                    if(cost < steps[v][curr.s+1]){
                      steps[v][curr.s + 1] = cost;
                      pq.offer(new Node(v, cost, curr.s + 1));
                    }
                }
           }
        }

        return -1;
    }
}