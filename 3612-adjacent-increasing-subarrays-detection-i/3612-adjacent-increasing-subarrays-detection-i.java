class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        //if(k==1 && nums.size()==2)return true;
        for(int i=0;i<=nums.size()-(k*2);i++){
            if(ch(nums,k,i))return true;
        }
        return false;
    }
    public boolean ch(List<Integer> nums, int k,int st){
        //System.out.println((st)+" "+"first fails");
        for(int i=st;i<st+k-1;i++){
            if(nums.get(i)>=nums.get(i+1))return false;
        }
        //System.out.println((st+k)+" "+"second fails");
        for(int i=st+k;i<st+k+k-1;i++){
            if(nums.get(i)>=nums.get(i+1))return false;
        }
        return true;
    }
}