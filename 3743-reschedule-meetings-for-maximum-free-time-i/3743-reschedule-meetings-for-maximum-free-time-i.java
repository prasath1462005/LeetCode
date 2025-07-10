class Solution {
    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        int[] sum=new int[startTime.length+1];
        sum[0]=startTime[0];
        for(int i=0;i<startTime.length-1;i++){
            sum[i+1]=startTime[i+1]-endTime[i];
        }  
        sum[sum.length-1]=eventTime-endTime[endTime.length-1];
        /*for(int i=0;i<sum.length;i++){
            System.out.print(sum[i]+" ");
        }*/
        int ans=0;
        int cs=0;
        //System.out.println();
        for(int i=0;i<sum.length;i++){
            cs+=sum[i]-((i>=k+1)?sum[i-(k+1)]:0);
            ans=Math.max(ans,cs);
        }
        return ans;
    }
}