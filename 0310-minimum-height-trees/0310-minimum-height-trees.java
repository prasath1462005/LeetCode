class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        Queue<Integer> q=new LinkedList<>();
        List<List<Integer>> l=new ArrayList<>();
        for(int i=0;i<n;i++)l.add(new ArrayList<>());
        int[] ind=new int[n];
        List<Integer> ans=new ArrayList<>();
        for(int[] nn:edges){
            l.get(nn[0]).add(nn[1]);
            l.get(nn[1]).add(nn[0]);
            ind[nn[0]]++;
            ind[nn[1]]++;
        }
        for(int i=0;i<n;i++){
            //System.out.print(ind[i]+" ");
            if(ind[i]==1){
                q.add(i);
                ind[i]--;
            }
        }
        //System.out.println();
        while(!q.isEmpty()){
            int size=q.size();
            ans.clear();
            //System.out.println(q);
            for(int i=0;i<size;i++){
                int curr=q.poll();
                ans.add(curr);
                for(int nn:l.get(curr)){
                    ind[nn]--;
                    //System.out.println(nn+" "+ind[nn]);
                    if(ind[nn]==1)q.add(nn);
                }
            }
        }
        if(n==1)ans.add(0);
        return ans;
    }
}