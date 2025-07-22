class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int max=0;
        int ans=0;
        Set<Integer> s=new HashSet<>();
        int i=0;
        for(int j=0;j<nums.length;j++){
            while(s.contains(nums[j])){
                max-=nums[i];
                s.remove(nums[i]);
                i++;
            }
            s.add(nums[j]);
            ans=Math.max(ans,max+nums[j]);
            max+=nums[j];
            //System.out.println(max+" "+ans);
        }
        return ans;
    }
}