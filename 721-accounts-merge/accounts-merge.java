class Solution {
    static int [] parent;
    static int [] size;
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        HashMap<String,Integer> map = new HashMap<>();
        int n = accounts.size();

        parent = new int [n];
        size = new int [n];
        for(int i = 0;i<n;i++){
            parent[i] = i;
            size[i] =  1;
        }

        for(int i = 0;i<n;i++){
            for(int j = 1;j<accounts.get(i).size();j++){
                String mail = accounts.get(i).get(j);
                if(map.containsKey(mail)){
                    union(map.get(mail),i);
                }
                else{
                    map.put(mail,i);
                }
            }
        }

        //after the dsu connections arrange
        HashMap<Integer,ArrayList<String>> map2 = 
        new HashMap<>();

        for(Map.Entry<String,Integer> e: map.entrySet()){
          String m = e.getKey();
          int acc = e.getValue();

          //find the ultimate account
          int u_acc = find(acc);

          //to avoid unecessary repeating addition of arrayList
          //just add it when we found u_cc first
          if(!map2.containsKey(u_acc)){
            map2.put(u_acc,new ArrayList<>());
          }

          map2.get(u_acc).add(m);
        } 

        List<List<String>> res = new ArrayList<>();

        for(Map.Entry<Integer,ArrayList<String>> e:map2.entrySet()){
            List<String> account = new ArrayList<>();
            int accId = e.getKey();
            ArrayList<String> mails = e.getValue();
            String accHolder = accounts.get(accId).get(0);

            Collections.sort(mails);

            account.add(accHolder);
            account.addAll(mails);

            res.add(account);
        }

        return res;
    }

    public static void union(int u,int v){
       int p_u = find(u);
       int p_v = find(v);

       if(p_u == p_v)return;

       if(size[p_u] < size[p_v]){
        parent[p_u] = p_v;
        size[p_v] += size[p_u];
       }
       else{
        parent[p_v] = p_u;
        size[p_u] += size[p_v];
       }
    }

    public static int find(int x){
        if(x == parent[x])return x;
        return parent[x] = find(parent[x]);
    }
}