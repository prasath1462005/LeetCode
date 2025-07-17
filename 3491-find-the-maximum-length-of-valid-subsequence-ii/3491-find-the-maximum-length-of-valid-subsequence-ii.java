class Solution {
    public int maximumLength(int[] nums, int k) {
        int ans=0;
        Integer[][] dp=new Integer[nums.length][k];
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                ans=Math.max(ans,2+an(j,(nums[i]+nums[j])%k,nums,dp,k));
            }
        }
        return ans;
    }
    public int an(int ind,int curr,int[] num,Integer[][] dp,int k){
        if(ind>=num.length)return 0;
        if(dp[ind][curr]!=null)return dp[ind][curr];
        int ans=0;
        for(int i=ind+1;i<num.length;i++){
            if((num[ind]+num[i])%k==curr){
                ans=1+an(i,curr,num,dp,k);
                break;
            }
        }
        return dp[ind][curr]=ans;
    }
}