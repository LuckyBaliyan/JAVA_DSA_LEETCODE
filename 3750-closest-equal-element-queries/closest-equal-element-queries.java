class Solution {
    public static int bs(int t, ArrayList<Integer> ids){
        int l = 0;
        int r = ids.size() - 1;

        while(l <= r){
            int mid = l + (r - l)/2;

            if(ids.get(mid) == t)return mid;
            else if (ids.get(mid) > t)r = mid - 1;
            else l = mid + 1;
        }

        return -1;
    }
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        int n = nums.length;

        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], new ArrayList<>());
            }
            map.get(nums[i]).add(i);
        } // we can also use compute if Absent as well here 

        ArrayList<Integer> res = new ArrayList<>();

        for(int q : queries){
            int elem = nums[q];
            ArrayList<Integer> ids = map.get(elem);

            int size = ids.size();

            if(size == 1){
               res.add(-1);
               continue;
            } //single elem in arr

            int pos = bs(q, ids);

            int minD = Integer.MAX_VALUE;

            //calculate right distaces circular and normal
            int right = ids.get((pos + 1) % size);
            int d = Math.abs(right - q);
            int cirD = Math.abs(n - d);

            minD = Math.min(minD, Math.min(d, cirD));

            //calculate left
            int left = ids.get((pos - 1 + size) % size);
            d = Math.abs(left - q);
            cirD = Math.abs(n - d);

            minD = Math.min(minD, Math.min(cirD, d));

            res.add(minD);
        }

        return res;
    }
}