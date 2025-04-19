class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        long u=(long)c(nums,upper+1);
        long l=(long)c(nums,lower);
        return Math.abs(u-l);
    }
    public long c(int[] n,int v){
        int l=0,r=n.length-1;
        long rs=0;
        while(l<r){
            int s=n[l]+n[r];
            if(s<v){
                rs+=(long)(r-l);
                l++;
            }
            else{
                r--;
            }
        }
        return rs;
    }
}