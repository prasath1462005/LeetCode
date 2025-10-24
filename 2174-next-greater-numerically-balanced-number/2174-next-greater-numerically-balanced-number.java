class Solution {
    public int nextBeautifulNumber(int n) {
        int i;
        for(i=n+1;i<10000000;i++){
            if(isvalid(i))break;
        }
        return i;
    }
    public boolean isvalid(int n){
        int[] freq=new int[10];
        int t=n;
        while(t!=0){
            int tt=t%10;
            freq[tt]++;
            t/=10;
        }
        if(freq[0]!=0)return false;
        for(int i=1;i<10;i++){
            if(freq[i]==0)continue;
            if(freq[i]!=i)return false;
        }
        return true;
    }
}