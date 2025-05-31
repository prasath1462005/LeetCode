class Solution {
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2) {
        int n1=edges1.length+1;
        int n2=edges2.length+1;
        Boolean[] b=new Boolean[n1];
        Arrays.fill(b,false);
        int v[]=new int[n1];
        Queue<int[]> q=new LinkedList<>();
        List<List<Integer>> l=new ArrayList<>();
        for(int i=0;i<=n1;i++)l.add(new ArrayList<>());
        for(int[] n:edges1){
            l.get(n[0]).add(n[1]);
            l.get(n[1]).add(n[0]);
        }
        q.add(new int[]{0,0});
        v[0]=1;
        int e=0,o=0;
        while(!q.isEmpty()){
            int[] n=q.poll();
            if(n[1]%2==0){
                b[n[0]]=true;
                e++;
            }
            else{
                o++;
            }
            for(int nn:l.get(n[0])){
                if(v[nn]==0){
                    q.add(new int[]{nn,n[1]+1});
                    v[nn]=1;
                }
            }
        }
        List<List<Integer>> l2=new ArrayList<>();
        for(int i=0;i<=n2;i++)l2.add(new ArrayList<>());
        for(int[] n:edges2){
            l2.get(n[0]).add(n[1]);
            l2.get(n[1]).add(n[0]);
        }
        int[] v1=new int[n2];
        q.add(new int[]{0,0});
        v1[0]=1;
        int e1=0,o1=0;
        while(!q.isEmpty()){
            int[] n=q.poll();
            if(n[1]%2==0){
                e1++;
            }
            else{
                o1++;
            }
            for(int nn:l2.get(n[0])){
                if(v1[nn]==0){
                    q.add(new int[]{nn,n[1]+1});
                    v1[nn]=1;
                }
            }
        }
        int[] ans=new int[n1];
        for(int i=0;i<n1;i++){
            if(b[i]==true){
                ans[i]=e+Math.max(e1,o1);
            }
            else{
                ans[i]=o+Math.max(e1,o1);
            }
        }
        return ans;
    }
}