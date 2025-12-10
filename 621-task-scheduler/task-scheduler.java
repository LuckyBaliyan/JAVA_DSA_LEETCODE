class Solution {
    public int leastInterval(char[] tasks, int n) {
        int [] freq = new int[26];

        for(char ch:tasks){
            freq[ch - 'A']++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 0;i<26;i++){
            if(freq[i] > 0){
                pq.offer(freq[i]);
            }
        }

        int time = 0;
        while(!pq.isEmpty()){
            ArrayList<Integer> list = new ArrayList<>();

            for(int i = 1;i<=n+1;i++){
                if(!pq.isEmpty()){
                    int temp = pq.poll();
                    temp--;
                    list.add(temp);
                }
            }

            for(int f:list){
                if(f > 0){
                    pq.offer(f);
                }
            }

            if(pq.isEmpty()){
                time += list.size();
            }
            else{
                time += n+1;
            }
        }

        return time;
    }
}