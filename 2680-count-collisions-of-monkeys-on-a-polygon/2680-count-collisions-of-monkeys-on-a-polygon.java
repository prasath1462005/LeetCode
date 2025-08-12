class Solution {
    public int monkeyMove(int n) {
        long mod=1000000007;
        long base=2,res=1;
        while(n>0){
            if(n%2==1){
                res=(res*base)%mod;
            }
            base=(base*base)%mod;
            n>>=1;
        }
        return (int)((res-2+mod)%mod);
    }
}