class Solution {
    int mod=1000000007;
    public int countGoodNumbers(long n) {
        return (int)((ans(5,(n+1)/2)*ans(4,(n/2)))%mod);
    }
    public long ans(long x,long y){
        long ret=1;
        long m=x;
        while(y>0){
            if(y%2==1){
                ret=(m*ret)%mod;
            }
            m=(m*m)%mod;
            y/=2;
        }
        return ret;
    }
}