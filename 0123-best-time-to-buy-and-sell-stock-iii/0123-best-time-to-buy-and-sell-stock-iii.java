class Solution {
    public int maxProfit(int[] prices) {
        int[][] dp=new int[prices.length][4];
        for(int[] n:dp)Arrays.fill(n,-1);
        return check(prices,0,0,dp);
    }
    public int check(int[] p,int r,int i,int[][] dp){
        if(r==4 || i>p.length-1)return 0;
        if(dp[i][r]!=-1)return dp[i][r];
        int buy=0;
        int sell=0;
        int donothing=check(p,r,i+1,dp);
        if(r%2==0){
            buy=check(p,r+1,i+1,dp)-p[i];
        }
        else{
            sell=check(p,r+1,i+1,dp)+p[i];
        }
        dp[i][r]=Math.max(donothing,Math.max(buy,sell));
        return Math.max(donothing,Math.max(buy,sell));
    }
}