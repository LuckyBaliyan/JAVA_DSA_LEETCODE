class Solution {
    public void sortColors(int[] nums) {
        //Arrays.sort(nums);
        int k = nums.length - 1;
        int i = 0;
        int j = 0;

        while(j<=k){
            if(nums[j] == 2){
                swap(j,k,nums);
                k--;
            }
            else if(nums[j] == 0){
              swap(i,j,nums);
              i++;
              j++;
            }
            else j++;
        }

    }

    public void swap(int a, int b, int [] arr){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}