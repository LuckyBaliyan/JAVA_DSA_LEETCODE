class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;

        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        //sort on the basis of arrival time
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0], b[0]));

        int start = intervals[0][0];
        int end = intervals[0][1];

        for(int i = 1; i<n; i++){
           int a = intervals[i][0];
           int b = intervals[i][1];

           if(a <= end){
            end = Math.max(end, b);
           }
           else{
            res.add(new ArrayList<>(Arrays.asList(start, end)));

            start = a;
            end = b;
           }
        }

        res.add(new ArrayList<>(Arrays.asList(start, end)));

        int [][] arr= new int [res.size()][2];
        for(int i = 0; i<res.size(); i++){
            arr[i][0] = res.get(i).get(0);
            arr[i][1] = res.get(i).get(1);
        }

        return arr;
    }
}