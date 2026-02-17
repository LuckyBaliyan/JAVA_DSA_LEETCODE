class Solution {
    static class Pair{
        int node;
        double prob;

        Pair(int node,double prob){
            this.node = node;
            this.prob = prob;
        }
    }
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for(int i = 0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0;i<edges.length;i++){
           int u = edges[i][0];
           int v = edges[i][1];

           double prob = succProb[i];

           adj.get(u).add(new Pair(v,prob));
           adj.get(v).add(new Pair(u,prob));
        }

        // we are making maxHeap inorder to get bigger probablities
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)-> 
        Double.compare(b.prob, a.prob));
        
        double [] max = new double[n];
        Arrays.fill(max,0.0);
        max[start_node] = 0.0;

        pq.offer(new Pair(start_node,1.0));

        while(!pq.isEmpty()){
            Pair p = pq.poll();
            int node = p.node;
            double  prob = p.prob;

            if(node == end_node)return prob;

            if(prob < max[node])continue;

            for(Pair ne:adj.get(node)){
                double newProb = prob * ne.prob;
                if(newProb > max[ne.node]){
                    max[ne.node] = newProb;
                    pq.offer(new Pair(ne.node,newProb));
                }
            }
        }

        return 0.0;
    }
}