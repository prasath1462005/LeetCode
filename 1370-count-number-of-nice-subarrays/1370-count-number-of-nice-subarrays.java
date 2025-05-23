class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int n1=no(nums,k);
        int n2=no(nums,k-1);
        return Math.abs(n1-n2);
    }
    public int no(int[] nums,int k){
        int l=0,r=0,cut=0,sum=0;
        while(r<nums.length){
            sum+=(nums[r]%2);
            while(sum>k){
                sum-=(nums[l]%2);
                l++;
            }
            cut+=(l-r+1);
            r++;
        }
        return cut;
    }
}