class Solution {
    public int maxHeight(int[][] cuboids) {
        return solve(cuboids);
    }

    public static int solve(int [][] arr){
        int n = arr.length;

        // sort the dimensions
        for(int [] a:arr){
            Arrays.sort(a);
        }

        //Sort the cubiods 
        Arrays.sort(arr, (a, b) -> {
          if (a[0] != b[0]) return b[0] - a[0];
          if (a[1] != b[1]) return b[1] - a[1];
          return b[2] - a[2];
        });

        int [] curr = new int [n+1];
        int [] next = new int [n+1];

        for(int i = n-1;i>=0;i--){
            for(int j = -1;j<=i-1;j++){
                int take = 0;
                if(j == -1 || arr[j][0] >= arr[i][0] && arr[j][1] >= arr[i][1]
                && arr[j][2] >= arr[i][2]){
                    take = next[i+1]+arr[i][2];
                }

                int notTake = next[j+1];

                curr[j+1] = Math.max(take,notTake);
            }

            next = curr.clone();
        }

        return next[0];
    }
}