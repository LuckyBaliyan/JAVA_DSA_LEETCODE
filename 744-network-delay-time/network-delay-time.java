class Solution {
    static class Pair{
        int weight;
        int node;

        Pair(int weight,int node){
            this.weight = weight;
            this.node = node;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        int [] distance = new int[n+1];

        for(int i = 0;i<=n;i++){
            adj.add(new ArrayList<>());
        }

        for(int [] e: times){
            int u = e[0];
            int v = e[1];
            int w = e[2];

            adj.get(u).add(new Pair(w,v));
        }

        Arrays.fill(distance,Integer.MAX_VALUE);
        distance[k] = 0;

        Dijkastra(distance,adj,k);

       int maxNetworkDelay = 0;
       for(int i = 1;i<=n;i++){
          if(distance[i] == Integer.MAX_VALUE)return -1;
          maxNetworkDelay = Math.max(maxNetworkDelay,distance[i]);
       }

       return maxNetworkDelay;
    }

    public static void Dijkastra(int [] distance,ArrayList<ArrayList<Pair>> adj,int k){
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)-> Long.compare(a.weight,b.weight));
        pq.offer(new Pair(0, k));

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            int u=curr.node;
            int d=curr.weight;

            if(d > distance[u]) continue;

            for(Pair ne:adj.get(u)){
                int v = ne.node;
                int w = ne.weight;

                if(d + w < distance[v]){
                    distance[v] = d + w;
                    pq.offer(new Pair(distance[v],v));
                }
            }
        }

    }
}