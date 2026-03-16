class Solution {
    static Pair [] seg;
    static class Pair{
        long maxLen, lisCnt;
        Pair(long maxLen, long lisCnt){
            this.maxLen = maxLen;
            this.lisCnt = lisCnt;
        }
    }

    public static Pair merge(Pair p1,Pair p2){
        long leftLen = p1.maxLen;
        long rightLen = p2.maxLen;

        long cntL = p1.lisCnt;
        long cntR = p2.lisCnt;

        //case 1:- if left is greater return same 
        if(leftLen > rightLen)return p1;
        else if(leftLen < rightLen)return p2;
        else return new Pair(leftLen,cntL + cntR);
    }

    public static Pair query(int idx,long l,long r,long ql, long qr){
        if(r < ql || l > qr) return new Pair(0, 0);
        if(ql <= l && r <= qr)return seg[idx];

        long mid = l+(r-l)/2;
        Pair p1 = query(2*idx,l,mid,ql,qr);
        Pair p2 = query(2*idx+1,mid + 1,r,ql,qr);

        return merge(p1,p2);
    }

    public static void update(int idx,long l,long r,long pos,Pair val){
        /*if(l==r){
            seg[idx] = val;
            return;
        }
        */

        if(l == r){
          Pair cur = seg[idx];
          if(val.maxLen > cur.maxLen){
            seg[idx] = val;
          }
          else if(val.maxLen == cur.maxLen){
            seg[idx] = new Pair(cur.maxLen, cur.lisCnt + val.lisCnt);
          }
       
           return;
        }

        long mid = l+(r-l)/2;

        if(pos<=mid)update(2*idx,l,mid,pos,val);
        else update(2*idx+1,mid + 1,r,pos,val);

        seg[idx] = merge(seg[2*idx],seg[2*idx+1]);
    }

    public int findNumberOfLIS(int[] nums) {
        //return solveTab(nums); --> O(N^2)
        return solveSeg(nums);
    }

    public static int solveSeg(int [] nums){
    int n = nums.length;

    int[] sorted = nums.clone();
    Arrays.sort(sorted);

    Map<Integer,Integer> map = new HashMap<>();

    int rank = 1;

    for(int x : sorted){
        if(!map.containsKey(x)){
            map.put(x, rank++);
        }
    }

    int range = rank - 1;

    seg = new Pair[4 * (range + 1)];

    for(int i = 0; i < seg.length; i++){
        seg[i] = new Pair(0,0);
    }

    for(int i : nums){

        long pos = map.get(i);

        Pair res = query(1,1,range,1,pos-1);

        long len = res.maxLen + 1;
        long cnt = (res.lisCnt == 0 ? 1 : res.lisCnt);

        update(1,1,range,pos,new Pair(len,cnt));
    }

    return (int) seg[1].lisCnt;
    }

    public static int solveTab(int [] arr){
        int n = arr.length;

        int [] curr = new int [n+1];
        int [] next = new int [n+1];
        int [] currCnt = new int [n+1];
        int [] nextCnt = new int [n+1];
       

        for(int j = 0;j<=n;j++)nextCnt[j] = 1;

        for(int i = n-1;i>=0;i--){
            for(int j = -1;j<=i-1;j++){
                int take = 0,takeCnt = 0;
                if(j == -1 || arr[i] > arr[j]){
                    take = 1 + next[i+1];
                    takeCnt = nextCnt[i+1];
                }

                int notTake = next[j+1];
                int notTakeCnt = nextCnt[j+1];

                curr[j+1] = Math.max(take, notTake);

                if(take > notTake){
                    currCnt[j+1] = takeCnt;
                }
                else if(take < notTake){
                    currCnt[j+1] = notTakeCnt;
                }
                else currCnt[j+1] = takeCnt + notTakeCnt;
            }

            next = curr.clone();
            nextCnt = currCnt.clone();
        }

        return nextCnt[0];
    }
}