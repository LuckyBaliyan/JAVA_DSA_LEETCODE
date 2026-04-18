class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;

        if(n == 1)return new int [] {nums[0]};

        ArrayList<Integer> res = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> b[0] - a[0]
        );


        for(int i = 0; i < n; i++){
            pq.offer(new int [] {nums[i], i});
            while(pq.peek()[1] <= i - k)pq.poll();

            //start picking after the first window
            if(i >= k - 1)res.add(pq.peek()[0]);
        }

        int size = res.size();
        int [] ans = new int [size];
        int idx = 0;

        for(int num: res){
            ans[idx++] = num;
        }
        
        return ans;
    }
}