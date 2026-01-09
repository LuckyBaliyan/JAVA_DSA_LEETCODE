class Solution {
    public String frequencySort(String s) {
        int n = s.length();

        int [] freq = new int [128];
        PriorityQueue<int []> pq = new PriorityQueue<>((a,b)->
        b[1] - a[1]);

        StringBuilder sb = new StringBuilder();

        //store frequency of each char
        for(int i:s.toCharArray()){
            freq[i]++;
        }

        //check where ever we see the count > 0 i.e the character do stored 
        // there
        for(int i = 0;i<128;i++){
            if(freq[i] > 0)
            pq.offer(new int [] {i,freq[i]});
        }

        while(!pq.isEmpty()){
           int [] top = pq.poll();
           int k = top[1];
           char ch = (char) top[0];

           while(k>0){
            sb.append(ch);
            k--;
           }
        }

        return sb.toString();
    }
}