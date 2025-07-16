class Solution {
    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        for(int i=0;i<n;i++){
            if(group[i]==-1)group[i]=m++;
        }
        HashMap<Integer,List<Integer>> h=new HashMap<>();
        for(int i=0;i<n;i++){
            if(h.containsKey(group[i])){
                h.get(group[i]).add(i);
            }
            else{
                List<Integer> l=new ArrayList<>();
                l.add(i);
                h.put(group[i],l);
            }
        }
        int[] groupitem=new int[m];
        int[] depency=new int[n];
        List<List<Integer>> l=new ArrayList<>();
        for(int i=0;i<n;i++)l.add(new ArrayList<>());
        for(int i=0;i<n;i++){
            for(int nn:beforeItems.get(i)){
                l.get(nn).add(i);
                depency[i]++;
                if(group[i]!=group[nn]){
                    groupitem[group[i]]++;
                }
            }
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<m;i++)if(groupitem[i]==0)q.add(i);
        List<Integer> ans=new ArrayList<>();
        //for(int i=0;i<n;i++)System.out.print(depency[i]+" ");
        //System.out.println(q);
        while(!q.isEmpty()){
            int curr=q.poll();
            List<Integer> ll=h.getOrDefault(curr, new ArrayList<>());
            Queue<Integer> pq=new LinkedList<>();
            for(int nn:ll){
                if(depency[nn]==0){
                    pq.add(nn);
                }
            }
            //System.out.println(pq);
            while(!pq.isEmpty()){
                int v=pq.poll();
                ans.add(v);
                for(int nn:l.get(v)){
                    depency[nn]--;
                    if(group[v]!=group[nn]){
                        groupitem[group[nn]]--;
                        if(groupitem[group[nn]]==0)q.add(group[nn]);
                        continue;
                    }
                    if(depency[nn]==0)pq.add(nn);
                }
            }
        }
        int[] an=new int[n];
        if(ans.size()!=n)return new int[0];
        for(int i=0;i<n;i++)an[i]=ans.get(i);
        return an;
    }
}