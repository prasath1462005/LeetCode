class Solution {
public:
    long long countSubarrays(vector<int>& nums, int k) {
        auto m=minmax_element(nums.begin(),nums.end());
        long long start=0,ans=0;
        int maxcount=0;
        for(int end=0;end<nums.size();end++){
            if(nums[end]==*m.second){
                maxcount++;
            }
            while(maxcount==k){
                if(nums[start]==*m.second){
                    maxcount--;
                }
                start++;
            }
            ans+=start;
        }
        return ans;
    }
};