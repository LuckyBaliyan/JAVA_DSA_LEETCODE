class Solution {
    static int n;
    public int[] twoSum(int[] numbers, int target) {
        n = numbers.length;
        if(n <= 1)return new int [] {-1, -1};

        //Approach 1:- BS + diff O(N*LOG N)
       //return solve1(numbers, target);

       //Approach 2:- two pointers O(N)
       return solve2(numbers, target);
    }

    public static int[] solve2(int [] arr, int t){
        int l = 0;
        int r = n-1;

        while(l <= r){
            int sum = arr[l] + arr[r];

            if(sum == t)return new int [] {l + 1, r + 1};
            else if(sum < t)l++;
            else r--;
        }

        return new int [] {-1, -1};
    }

    public static int [] solve1(int [] arr, int t){
        for(int i = 0; i<n; i++){
            int diff = t - arr[i];

            int idx = bs(arr,i+1,n-1, diff);

            if(idx != -1)return new int [] {i + 1, idx + 1};
        }

        return new int [] {-1, -1};
    }

    public static int bs(int [] arr, int l, int r, int t){
        while(l<=r){
            int mid = l + (r-l)/2;

            if(arr[mid] == t)return mid;
            else if(arr[mid] > t)r = mid - 1;
            else l = mid + 1;
        }

        return -1;
    }
}