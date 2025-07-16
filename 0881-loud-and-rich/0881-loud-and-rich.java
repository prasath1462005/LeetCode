class Solution {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int n=quiet.length;
        List<List<Integer>> l=new ArrayList<>();
        for(int i=0;i<n;i++)l.add(new ArrayList<>());
        int[] indg=new int[n];
        for(int[] nn:richer){
            l.get(nn[0]).add(nn[1]);
            indg[nn[1]]++;
        }
        int[] ans=new int[n];
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            if(indg[i]==0)q.add(i);
            ans[i]=i;
        } 
        while(!q.isEmpty()){
            int curr=q.poll();
            for(int n1:l.get(curr)){
                if(quiet[ans[curr]]<quiet[ans[n1]]){
                    ans[n1]=ans[curr];
                }
                indg[n1]--;
                if(indg[n1]==0)q.add(n1);
            }
        }
        return ans;
    }
}