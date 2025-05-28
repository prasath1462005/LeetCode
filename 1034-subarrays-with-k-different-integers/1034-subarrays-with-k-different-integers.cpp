class Solution {
public:
    int subarraysWithKDistinct(vector<int>& nums, int k) {
        int k1=sub(nums,k);
        int k2=sub(nums,k-1);
        return k1-k2;
    }
    int sub(vector<int>& nums, int k){
        map<int,int> m;
        int r=0,l=0,cut=0;
        while(r<nums.size()){
            m[nums[r]]++;
            while(m.size()>k){
                m[nums[l]]--;
                if(m[nums[l]]==0)m.erase(nums[l]);
                l++;
            }
            cut+=(r-l+1);
            r++;
        }
        return cut;
    }
};