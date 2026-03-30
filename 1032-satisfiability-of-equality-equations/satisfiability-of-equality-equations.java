class Solution {
    static int [] parent;
    static int [] size;

    public static void init(int n){
        parent = new int [n];
        size = new int [n];

        for(int i = 0;i<n;i++){
            parent[i] = i;
            size[i] = 1;
        }
    }


    public static int find(int x){
        if(x == parent[x])return x;
        return parent[x] = find(parent[x]);
    }

    public static void union(int a, int b){
        int pa = find(a);
        int pb = find(b);

        if(pa == pb)return;

        if(pa < pb){
            parent[pa] = pb;
            size[pb] += size[pa];
        }
        else{
           parent[pb] = pa;
           size[pa] += size[pb];
        }
    }


    public boolean equationsPossible(String[] equations) {
        init(26); // max size of the parent array [a-z]

        //try the == equations first beacuse they ar't causing 
        //any problem

        for(String s:equations){
            //take first and last variable
            int u = s.charAt(0) - 'a';
            int v = s.charAt(3) - 'a';

            if(s.charAt(1) != '!'){
                union(u,v);
            }
        }

        //Now just have to check the transitive dependency for the 
        //problematic equation

        for(String s: equations){
            int u = s.charAt(0) - 'a';
            int v = s.charAt(3) - 'a';

            if(s.charAt(1) == '!'){
                //there is a thrid variable both are dependent 
                // hence both are equal but we have to statify 
                //the != equation which is clearly false here
                if(find(u) == find(v))return false;
            }
        }

        return true;
    }
}