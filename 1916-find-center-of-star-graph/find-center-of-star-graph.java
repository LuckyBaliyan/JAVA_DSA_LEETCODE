class Solution {
    public int findCenter(int[][] edges) {
        // make adj list and count degree at each node
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int n = edges.length + 1;

        for(int i = 0;i<=n;i++){
            adj.add(new ArrayList<>());
        }

        for(int [] e:edges){
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        int maxDegreeNode = 0;
        int center  = 0;
        for(int i = 0;i<adj.size();i++){
           if(maxDegreeNode < adj.get(i).size()){
            maxDegreeNode = adj.get(i).size();
            center = i;
           }
        }

        return center;
    }
}