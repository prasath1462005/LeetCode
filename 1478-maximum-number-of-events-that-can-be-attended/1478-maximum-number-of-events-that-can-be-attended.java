class Solution {
    public int maxEvents(int[][] events) {
        PriorityQueue<int[]> p=new PriorityQueue<>( (a,b)->{
            if(a[0]!=b[0]){
                return a[0]-b[0];
            }
            return a[1]-b[1];
        });
        int d=1;
        int m=0;
        for(int[] n:events){
            if(n[1]>m)m=n[1];
            p.add(n);
        }
        int ans=0;
        PriorityQueue<int[]> pq=new PriorityQueue<>( (a,b)->{
            if(a[1]!=b[1]){
                return a[1]-b[1];
            }
            return a[0]-b[0];
        });
        int place=1;
        while(d<=m){
            while(!p.isEmpty() && p.peek()[0]==d){
                pq.add(p.poll());
            }
            while(!pq.isEmpty() && pq.peek()[1]<d){
                pq.poll();
            }
            if(!pq.isEmpty()){
                pq.poll();
                ans++;
            }
            d++;
        }
        return ans;
    }
}