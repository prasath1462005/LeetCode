class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int n1=no(nums,goal);
        int n2=no(nums,goal-1);
        return n1-n2;
    }
    public int no(int[] nums,int goal){
        int l=0,r=0,cut=0,sum=0;
        if(goal<0)return 0;
        while(r<nums.length){
            sum+=nums[r];
            while(sum>goal){
                sum-=nums[l];
                l++;
            }
            cut+=(r-l+1);
            r++;
        }
        return cut;
    }
}