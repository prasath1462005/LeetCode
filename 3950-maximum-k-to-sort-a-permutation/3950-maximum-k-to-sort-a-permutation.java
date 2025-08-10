class Solution {
    public int sortPermutation(int[] nums) {
        int max=0;
        int[] v=new int[nums.length];
        List<Integer> l=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(i==nums[i])continue;
            if(v[i]!=1){
                v[i]=1;
                l.add(dfs(nums,nums[i],i,v));
            }
        }
        Collections.sort(l);
        //System.out.println(l);
        if(l.isEmpty())return 0;
        return l.get(0);
    }
    public int dfs(int[] nums,int i,int ans,int[] v){
        //System.out.println(ans);
        if(v[i]==1)return ans;
        v[i]=1;
        return dfs(nums,nums[i],ans&i,v);
    }
}