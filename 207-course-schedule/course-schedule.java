class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i = 0; i<numCourses; i++)adj.add(new ArrayList<>());

        for(int [] p: prerequisites){
           //make dependecy fom b --> a
           adj.get(p[1]).add(p[0]);
        }

        int [] inDegree = new int [numCourses];

        for(int i = 0; i<numCourses; i++){
            for(int ne: adj.get(i)){
                inDegree[ne]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        //add all 0 indegree src to queue
        for(int i = 0; i < numCourses; i++){
            if(inDegree[i] == 0){
               q.offer(i);
            }
        }

        int used = 0;

        while(!q.isEmpty()){
            int curr = q.poll();
            used++;

            for(int ne : adj.get(curr)){
                inDegree[ne]--;

                if(inDegree[ne] == 0)q.offer(ne);
            }
        }

        return used == numCourses;
    }
}