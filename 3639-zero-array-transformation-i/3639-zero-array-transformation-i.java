class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int[] sub=new int[nums.length+1];
        for(int[] n:queries){
            sub[n[0]]+=1;
            sub[n[1]+1]-=1;
        }
        for(int i=1;i<sub.length;i++){
            sub[i]=sub[i]+sub[i-1];
        }
        for(int i=0;i<nums.length;i++){
            nums[i]=nums[i]-sub[i];
            if(nums[i]>0)return false;
        }
        return true;
    }
}