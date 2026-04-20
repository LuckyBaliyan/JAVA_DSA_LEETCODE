class NumArray {
    int [] tree;
    int [] nums;
    int idx;

    public NumArray(int[] nums) {
        this.nums = nums;
        tree = new int [4 * nums.length];
        idx = 0;

        buildTree(0, 0, nums.length - 1);
    }

    public void buildTree(int idx, int l, int r){
        if(l == r){
            tree[idx] = nums[l];
            return;
        }

        int mid = l + (r - l)/2;
        buildTree(2 * idx + 1, l, mid);
        buildTree(2 * idx + 2, mid + 1, r);

        tree[idx] = tree[2*idx + 1] + tree[2*idx + 2];
    }
    
    public void update(int index, int val) {
        nums[index] = val;
        updateHelper(idx,index,0,nums.length-1,val);
    }

    public void updateHelper(int idx, int qi, int l, int r, int val){
        if(l == r){
            tree[idx] = val;
            return;
        }

        int mid = l + (r-l)/2;
        if(qi <= mid)updateHelper(2*idx+1,qi,l,mid,val);
        else updateHelper(2*idx+2,qi,mid + 1, r, val);

        tree[idx] = tree[2*idx + 1] + tree[2* idx + 2];
    }
    
    public int sumRange(int left, int right) {
        return query(idx, 0, nums.length-1, left, right);
    }

    public  int query(int idx, int l, int r, int ql, int qr){
        if(qr < l ||  ql > r)return 0;

        if(ql <= l && r <= qr)return tree[idx];

        int mid = l + (r - l)/2;
        int left = query(2*idx+1, l, mid, ql, qr);
        int right = query(2*idx+2, mid+1, r, ql, qr);

        return left + right;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */