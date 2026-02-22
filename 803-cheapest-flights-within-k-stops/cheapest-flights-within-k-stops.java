class Solution {
    static class Tuple{
        int node,cost,stop;

        Tuple(int node,int cost,int stop){
            this.node = node;
            this.cost = cost;
            this.stop = stop;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<Tuple>> adj = new ArrayList<>();

        for(int i = 0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int [] e:flights){
            adj.get(e[0]).add(new Tuple(e[1],e[2],0));
        }

        PriorityQueue<Tuple> pq = 
        new PriorityQueue<>((a,b)->Integer.compare(a.cost,b.cost));

        int [][] dist = new int [n][k+2]; // for each stop there will be stop + 1 edges
        for(int [] arr:dist)Arrays.fill(arr,Integer.MAX_VALUE);

        dist[src][0] = 0; 
        pq.offer(new Tuple(src,0,0));

        while(!pq.isEmpty()){
           Tuple curr = pq.poll();
           int node = curr.node;
           int cost = curr.cost;
           int stops = curr.stop;

           if(node == dst)return cost;

           if(stops > k)continue; 

           for(Tuple ne:adj.get(node)){
            int v = ne.node;
            int newCost = cost + ne.cost;
            if(newCost < dist[v][stops + 1]){
                dist[v][stops + 1] = newCost;
                pq.offer(new Tuple(v,newCost,stops + 1));
            }
           }
        }

        return -1;
    }
}