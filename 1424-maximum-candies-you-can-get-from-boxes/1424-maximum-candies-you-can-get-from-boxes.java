class Solution {
    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        Queue<Integer> q=new LinkedList<>();
        for(int n:initialBoxes)q.add(n);
        Set<Integer> s=new TreeSet<>();
        int tot=0;
        while(!q.isEmpty()){
            int v=q.poll();
            if(status[v]==0){
                s.add(v);
                continue;
            }
            for(int n:keys[v]){
                status[n]=1;
                if(s.contains(n)){
                    q.add(n);
                    s.remove(n);
                }
            }
            tot+=candies[v];
            for(int n:containedBoxes[v]){
                q.add(n);
            }
        }
        return tot;
    }
}