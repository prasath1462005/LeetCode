class Solution {
    public boolean isMatch(String s, String p) {
        int m=s.length();
        int n=p.length();
        Boolean[][] dp=new Boolean[m+1][n+1];
        return is(s,p,0,0,dp);
    }
    public boolean is(String s,String p,int i,int j,Boolean[][] dp){
        if(j==p.length())return i==s.length();
        if(dp[i][j]!=null)return dp[i][j];
        boolean fm=false;
        if(i<s.length() && (s.charAt(i)==p.charAt(j)||p.charAt(j)=='.'))fm=true;
        boolean ans=false;
        if(j+1<p.length() && p.charAt(j+1)=='*'){
            ans=(fm && is(s,p,i+1,j,dp)) || is(s,p,i,j+2,dp);
        }else{
            ans=fm&&is(s,p,i+1,j+1,dp);
        }
        dp[i][j]=ans;
        return dp[i][j];
    }
}