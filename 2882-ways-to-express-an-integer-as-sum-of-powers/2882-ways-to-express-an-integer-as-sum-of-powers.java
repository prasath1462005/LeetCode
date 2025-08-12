class Solution {
    int[][] dp;
    public int numberOfWays(int n, int x) {
        dp=new int[n+1][n+1];
        List<Integer> l=new ArrayList<>();
        int i=1;
        for(int[] nn:dp)Arrays.fill(nn,-1);
        while((int)Math.pow(i,x)<=n && (int)Math.pow(i,x)>=0){
            l.add((int)Math.pow(i,x));
            i++;
        }
        return no(l,0,0,n);
    }
    public int no(List<Integer> l,int i,int v,int n){
        if(i>=l.size() || v>n || v<0 )return 0;
        //System.out.println(l.get(i)+ " "+v);
        if(dp[i][v]!=-1)return dp[i][v];
        if(v+l.get(i)==n)return 1;
        int pick=no(l,i+1,v+l.get(i),n);
        int np=no(l,i+1,v,n);
        dp[i][v]=(pick+np)%1000000007;
        return dp[i][v];
    }
}