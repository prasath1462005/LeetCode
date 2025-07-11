class Solution {
    public int mostBooked(int n, int[][] meetings) {
        PriorityQueue<int[]> p=new PriorityQueue<>( (a,b)->Integer.compare(a[0],b[0]));
        for(int[] nn:meetings)p.add(nn);
        PriorityQueue<Integer> availe=new PriorityQueue<>();
        for(int i=0;i<n;i++)availe.add(i);
        PriorityQueue<int[]> isroom=new PriorityQueue<>((a,b)->{
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0]; 
        }   
        );
        int[] roomcount=new int[n];
        while(!p.isEmpty()){
            int[] arr=p.poll();
            int st=arr[0];
            int end=arr[1];
            while(!isroom.isEmpty() && isroom.peek()[0]<=st){
                availe.add(isroom.peek()[1]);
                isroom.poll();
            }
            if(!availe.isEmpty()){
                int rno=availe.poll();
                isroom.add(new int[]{end,rno});
                roomcount[rno]++;
            }
            else{
                int[] arr1=isroom.poll();
                int endd=arr1[0];
                int rno=arr1[1];
                int deadline=endd+(end-st);
                isroom.add(new int[]{deadline,rno});
                roomcount[rno]++;
            }
        }
        int ans=0;
        for(int i=1;i<n;i++){
            if(roomcount[i]>roomcount[ans]){
                ans=i;
            }
        }
        return ans;
    }
}