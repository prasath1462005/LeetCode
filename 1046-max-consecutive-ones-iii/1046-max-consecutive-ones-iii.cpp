class Solution {
public:
    int longestOnes(vector<int>& nums, int k) {
        int l=0,r,maxlen=0,z=0;
        for(r=0;r<nums.size();r++){
            if(nums[r]==0)z++;
            while(z>k){
                if(nums[l]==0)z--;
                //cout<<"in:"<<l<<endl;
                l++;
            }
            maxlen=max(maxlen,r-l+1);
            //cout<<z<<endl;
        }
        return maxlen;
    }
};