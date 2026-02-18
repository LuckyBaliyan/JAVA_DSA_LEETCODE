class Solution {
    static final int MOD = 1000000007;
    static class Pair{
        int node;
        long cost;

        Pair(int node,long cost){
            this.node = node;
            this.cost = cost;
        }
    }
    public int countPaths(int n, int[][] roads) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for(int i = 0;i<n;i++)adj.add(new ArrayList<>());

        for(int [] e:roads){
            int u = e[0];
            int v = e[1];
            long cost = e[2];

            adj.get(u).add(new Pair(v,cost));
            adj.get(v).add(new Pair(u,cost));
        }

        long [] time = new long [n];
        int [] ways = new int [n];

        PriorityQueue<Pair> q = 
        new PriorityQueue<>((a,b)->Long.compare(a.cost,b.cost));

        Arrays.fill(time,Long.MAX_VALUE);
        time[0] = 0;

        ways[0] = 1;

        q.offer(new Pair(0,0));

        while(!q.isEmpty()){
          Pair p = q.poll();
          int node = p.node;
          long d = p.cost;

          if(d > time[node])continue;
          
          for(Pair ne:adj.get(node)){
            int v = ne.node;
            long cost = ne.cost;

            if(d + cost < time[v]){
                time[v] = d + cost;
                ways[v] = ways[node];
                q.offer(new Pair(v,time[v]));
            }
            else if (d + cost == time[v])ways[v] = (ways[v] + ways[node])%MOD;
          }
        }

        return ways[n-1];
    }
}