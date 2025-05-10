class Solution {
public:
    int maxScore(vector<int>& cp, int k) {
        int lsum=0,max=0,i,rsum=0,j=cp.size()-1;
        for(i=0;i<k;i++)lsum+=cp[i];
        max=lsum;
        for(i=0;i<k;i++){
            lsum-=cp[k-1-i];
            rsum+=cp[j-i];
            max=std::max(max,lsum+rsum);
        }
        return max;
    }
};