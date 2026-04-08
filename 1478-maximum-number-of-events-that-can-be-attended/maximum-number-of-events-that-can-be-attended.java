class Solution {
    public int maxEvents(int[][] events) {
        int n = events.length;
        
        //make a priorityQueue and sort acc to startDay and in case of tie sort 
        // acc to endDay
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });

        for(int i = 0; i<n; i++){
            pq.offer(new int [] {events[i][0], events[i][1]});
        }

        PriorityQueue<Integer> endPq = new PriorityQueue<>();

        int days = 0;
        int currDay = 0;

        while(!pq.isEmpty() || !endPq.isEmpty()){
           if(endPq.isEmpty())currDay = pq.peek()[0];

           while(!pq.isEmpty() && pq.peek()[0] == currDay)
           endPq.offer(pq.poll()[1]);

           while(!endPq.isEmpty() && endPq.peek() < currDay)endPq.poll();

           if(!endPq.isEmpty()){
            endPq.poll();
            currDay++;
            days++;
           }
        }

        return days;
    }
}