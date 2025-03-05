class Solution {
    public long coloredCells(int n) {
        if(n==1)return 1;
        long fv=1;
        long st=4;
        for(int i=0;i<n-1;i++){
            fv=fv+st;
            st+=4;
        }
        return fv;
    }
}