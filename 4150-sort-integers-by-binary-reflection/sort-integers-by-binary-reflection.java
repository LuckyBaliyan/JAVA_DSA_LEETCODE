class Solution {
    public int[] sortByReflection(int[] nums) {
        int n = nums.length;

        if(n == 1)return new int [] {nums[0]};
        int [] res =  new int [n];

        ArrayList<int []> list = new ArrayList<>();

        for(int i = 0;i<n;i++){
          StringBuilder sb = new StringBuilder();
          sb.append(Integer.toBinaryString(nums[i]));
          sb.reverse();
          list.add(new int [] {nums[i],Integer.parseInt(sb.toString(),2),i});
        }

       Collections.sort(list,(a,b)->{
            if(a[1] != b[1]) return a[1] - b[1];
            return a[0] - b[0];
        });
        

        for(int i = 0;i<n;i++){
            res[i] = list.get(i)[0];
        }

        return res;
    }
}