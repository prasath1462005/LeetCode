class Solution {
    int[][] dp=new int[26][26];
    public int minimumDeletions(String word, int k) {
        int[] freq=new int[26];
        for(char s:word.toCharArray()){
            freq[s-'a']++;
        }
        Arrays.sort(freq);
        for(int[] n:dp)
        Arrays.fill(n,-1);
        return solve(freq,k,0,25);
    }
    public int solve(int[] freq,int k,int i,int j){
        if(freq[i]==freq[j])return 0;
        if(freq[j]-freq[i]<=k)return 0;
        if(dp[i][j]!=-1)return dp[i][j];
        return dp[i][j]=Math.min(freq[i]+solve(freq,k,i+1,j),Math.abs(freq[j]-freq[i]-k)+solve(freq,k,i,j-1));
    }
}