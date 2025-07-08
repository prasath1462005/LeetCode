class Solution {
    public int maxValue(int[][] events, int k) {
        Arrays.sort(events, (a, b) -> a[0] - b[0]);
        int n=events.length;
        int[][] dp=new int[k+1][n];
        for(int[] nn:dp)Arrays.fill(nn,-1);
        return event(0,k,events,dp);
    }
    public int event(int i,int c,int[][] e,int[][] dp){
        if(c==0 || i==e.length)return 0;
        if(dp[c][i]!=-1)return dp[c][i];
        int nextindex=bin(e[i][1],e);
        int np=event(i+1,c,e,dp);
        int p=e[i][2]+event(nextindex,c-1,e,dp);
        dp[c][i]=Math.max(np,p);
        return dp[c][i];
    }
    public int bin(int t,int[][] e){
        int l=0,r=e.length;
        while(l<r){
            int mid=(l+r)/2;
            if(e[mid][0]<=t){
                l=mid+1;
            }
            else{
                r=mid;
            }
        }
        return l;
    }
}