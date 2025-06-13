class Solution {
    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);
        int l=0,h=nums[nums.length-1],mid;
        int ans=0;
        while(l<=h){
            mid=l+(h-l)/2;
            if(poss(nums,mid,p)){
                ans=mid;
                h=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return ans;
    }
    public Boolean poss(int[] num,int val,int p){
        int i=1;
        int c=0;
        while(i<num.length){
            if(num[i]-num[i-1]<=val){
                c++;
                i+=2;
            }
            else{
                i++;
            }
        }
        return c>=p;
    }
}