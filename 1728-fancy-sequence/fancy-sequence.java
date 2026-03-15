class Fancy {
    static long M =  1000000007;
    static ArrayList<Long> seq;
    static long add;
    static long mult;

    public static long power(long a, long b){
        if(b == 0)return 1;

        long half = power(a, b/2);
        long res = (half * half) % M;

        if(b % 2 == 1)res = (res * a) % M;

        return res;
    }

    public Fancy() {
        seq = new ArrayList<>();
        add = 0;
        mult = 1;
    }
    
    public void append(int val) {
        long x = ((val - add) % M + M)* power(mult, M-2) % M;
        seq.add(x);
    }
    
    public void addAll(int inc) {
        add = (add + inc) % M;
    }
    
    public void multAll(int m) {
        add = (add * m) % M;
        mult = (mult * m) % M;
    }
    
    public int getIndex(int idx) {
        if(idx >= seq.size())return -1;

        return (int)((seq.get(idx) * mult + add) % M);
    }
}

/**
 * Your Fancy object will be instantiated and called as such:
 * Fancy obj = new Fancy();
 * obj.append(val);
 * obj.addAll(inc);
 * obj.multAll(m);
 * int param_4 = obj.getIndex(idx);
 */