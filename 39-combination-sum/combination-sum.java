class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int n = candidates.length;
        List<List<Integer>> res = new ArrayList<>();

        solve(0, n, candidates, new ArrayList<>(), res, target);
        return res;
    }

    public static void solve(int i, int n, int [] arr, List<Integer> curr, 
    List<List<Integer>> res, int t){
        if(i>=n)return;

        if(t == 0){
            res.add(new ArrayList<>(curr));
            return;
        }

        //take 
        if(arr[i] <= t){
            curr.add(arr[i]);
            //stay on same idx because a elem can contribute multiple times
            solve(i, n, arr, curr, res, t - arr[i]);
            curr.remove(curr.size() - 1);
        }

        //skip 
        solve(i+1, n, arr, curr, res, t);
    }
}