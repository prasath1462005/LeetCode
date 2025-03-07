class Solution {
    boolean[] p=new boolean[1000001];
    public Solution(){
        p[1]=true;
        p[2]=false;
        for(int i=2;i<100001;i++){
            if(p[i]==false){
                for(int j=i*2;j<1000001;j+=i){
                    p[j]=true;
                }
            }
        }
    }
    public int[] closestPrimes(int left, int right) {
        int min=Integer.MAX_VALUE;
        int x=-1;
        int ll=-1;
        int rr=-1;
        for(int i=left;i<=right;i++){
            if(!p[i]){
                if(i-x<min){
                    ll=x;
                    rr=i;
                    min=i-x;
                }
                x=i;
            }
        }
        if(ll==-1 || rr==-1)return new int[]{-1,-1};
        return new int[]{ll,rr};
    }
}