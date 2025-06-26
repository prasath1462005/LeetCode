class Solution {
    public int longestSubsequence(String s, int k) {
        int[][] dp=new int[s.length()][s.length()];
        for(int[] n:dp)Arrays.fill(n,-1);
        return ch(s.length()-1,0,k,s,dp);
    }
    public int ch(int i,int size,int k,String s,int[][] dp){
        if(i<0)return 0;
        if(dp[i][size]!=-1)return dp[i][size];
        int no=ch(i-1,size,k,s,dp);
        int yes=0;
        int v=k-(s.charAt(i)-'0')*(int)Math.pow(2,size);
        if(v>=0){
            yes=1+ch(i-1,size+1,v,s,dp);
        }
        return dp[i][size]=Math.max(no,yes);
    }
}