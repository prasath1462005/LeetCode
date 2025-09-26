class Solution {
    public int triangleNumber(int[] nums) {
        int c=0;
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                int sum=nums[i]+nums[j];
                int idx=bin(nums,sum,j+1,nums.length-1);
                if(idx!=0)
                c+=(idx-j);
            }
        }
        return c;
    }
    public int bin(int[] n,int s,int l,int r){
        int idx=-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(n[mid]<s){l=mid+1;idx=mid;}
            else r=mid-1;
        }
        return idx==-1?0:idx;
    }
}