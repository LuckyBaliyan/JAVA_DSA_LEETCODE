class Solution {
    static int [] par;
    static int [] size;

    public static int find(int x){
        if(par[x] == x)return x;
        return par[x] = find(par[x]);
    }

    public static void union(int u, int v){
        int pu = find(u);
        int pv = find(v);

        if(pu == pv)return;

        if(size[pu] > size[pv]){
            par[pv] = pu;
            size[pu] += size[pv];
        }
        else{
            par[pu] = pv;
            size[pv] += size[pu];
        }
    }

    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        int n = source.length;
        int ans = 0;
        
        par = new int [n];
        size = new int [n];

        for(int i = 0; i<n; i++){
            par[i] = i;
            size[i] = i;
        }
        
        for(int [] a : allowedSwaps){
            union(a[0], a[1]);
        }

        Map<Integer, ArrayList<Integer>> map = new HashMap<>();

        //track each component parent and all idx associated with it
        for(int i = 0; i<n; i++){
            int p = find(i);
            map.computeIfAbsent(p, k->new ArrayList<>()).add(i);
        }

        //now lets just check for each idx wheather it is 
        // comman or not 

        for(List<Integer> idx : map.values()){
            Map<Integer, Integer> freq = new HashMap<>();

            //add values of sources
            // the curr idx to match later with target
            for(int i: idx){
               freq.put(source[i], freq.getOrDefault(source[i], 0)+1);
            }

            for(int i: idx){
                int val = target[i];

                if(freq.getOrDefault(val, 0) > 0){
                    freq.put(val, freq.get(val) - 1);
                }
                else{
                    ans++;
                }
            }
        }

        return  ans;
    }
}