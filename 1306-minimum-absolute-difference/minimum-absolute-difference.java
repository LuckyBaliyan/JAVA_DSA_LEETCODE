class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);

        List<List<Integer>> res = new ArrayList<>();
        int M = Integer.MAX_VALUE;

        for(int i = 0;i<arr.length - 1;i++){
            int first = arr[i];
            int sec = arr[i+1];
            int diff = Math.abs(first - sec);

            if(diff < M){
                M = diff;
                res.clear();
                res.add(Arrays.asList(arr[i], arr[i+1]));
            }
            else if(diff == M){
               res.add(Arrays.asList(arr[i], arr[i+1]));
            }
        }

        return res;
    }
}