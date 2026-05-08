class Solution {
    public static boolean [] isPrime;

    public static void buildSieve(int max){
        isPrime = new boolean [max+1];
        Arrays.fill(isPrime, true);

        isPrime[0] = false;
        isPrime[1] = false;

        for(int i = 2; i*i <=max; i++){
            if(isPrime[i]){
                for(int j = 2; i*j <=max; j++){
                    isPrime[i*j] = false;
                }
            }
        }
    }
    
    public int minJumps(int[] nums) {
        int n = nums.length;

        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int maxEl = 0;

        for(int i = 0; i<n; i++){
            map.putIfAbsent(nums[i], new ArrayList<>());
            // add index to list
            map.get(nums[i]).add(i);

            maxEl = Math.max(maxEl, nums[i]);
        }

        buildSieve(maxEl);

        boolean [] visited = new boolean [n+1];
        Queue<Integer> q = new LinkedList<>();
        HashSet<Integer> seen = new HashSet<>();

        q.offer(0);
        visited[0] = true;

        int steps = 0;

        while(!q.isEmpty()){
            int size = q.size();

            while(size-->0){
                int i = q.poll();

                if(i == n-1)return steps;

                if(i-1 >=0 && !visited[i-1]){
                    q.offer(i-1);
                    visited[i-1] = true;
                }

                if(i+1 < n && !visited[i+1]){
                    q.offer(i+1);
                    visited[i+1] = true;
                }

                if(!isPrime[nums[i]] || seen.contains(nums[i]))continue;

                //if the number isPrime push all the reachable index to q
                for(int mul = nums[i]; mul <= maxEl; mul += nums[i]){
                    if(!map.containsKey(mul))continue;

                    for(int j : map.get(mul)){
                        if(!visited[j]){
                            q.offer(j);
                            visited[j] = true;
                        }
                    }
                }

                seen.add(nums[i]); // to avoid recalculation of prime of same
            }

            steps++;
        }

        return steps;
    }
}