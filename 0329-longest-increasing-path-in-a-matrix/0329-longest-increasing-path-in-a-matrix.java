class Solution {
    int[][] vis;
    int[][] dp;
    int[][] dir=new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
    public int longestIncreasingPath(int[][] m) {
        vis=new int[m.length][m[0].length];
        dp=new int[m.length][m[0].length];
        int max=0;
        for(int i=0;i<m.length;i++){
            for(int j=0;j<m[0].length;j++){
                int v=0;
                if(dp[i][j]==0)v=dfs(i,j,m);
                max=Math.max(max,v);
                if(dp[i][j]<v)dp[i][j]=v;
            }
        }
        return max;
    }
    public int dfs(int r,int c,int[][] m){
        int in=0;
        if(dp[r][c]!=0){
            return dp[r][c];
        }
        vis[r][c]=1;
        int max=0;
        for(int[] n:dir){
            int nr=n[0]+r;
            int nc=n[1]+c;
            if(nr>=0 && nr<m.length && nc>=0 && nc<m[0].length && vis[nr][nc]!=1 && m[r][c]<m[nr][nc]){
                in=1;
                int v=1+dfs(nr,nc,m);
                max=Math.max(max,v);
                dp[r][c]=max;
                
            }
        }
        vis[r][c]=0;
        if(in==1)return max;
        return 1;
    }
}