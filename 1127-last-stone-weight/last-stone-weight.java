class Solution {
    public int lastStoneWeight(int[] stones) {
        int n = stones.length;

        if(n == 1)return stones[0];

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for(int s:stones){
            maxHeap.offer(s);
        }

        while(maxHeap.size()>1){
        int y = maxHeap.poll();
        int x = maxHeap.poll();

        if(x!=y){
            maxHeap.offer(y - x);
        }

        }  

        if(maxHeap.size() == 0)return 0;
        return maxHeap.poll();    
    }
}