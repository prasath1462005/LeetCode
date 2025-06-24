class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> l=new ArrayList<>();
        List<Integer> l1=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]==key)l.add(i);
        }
        for(int i=0;i<nums.length;i++){
            for(int n:l){
                if(Math.abs(i-n)<=k){
                    l1.add(i);
                    break;
                }
            }
        }
        return l1;
    }
}