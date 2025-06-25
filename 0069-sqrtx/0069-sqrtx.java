class Solution {
    public int mySqrt(int x) {
       if(x==0 || x==1)return x;
       int i=1,j=x;
       int mid=-1;
       while(i<=j){
        mid=i+(j-i)/2;
        if((long)mid*mid>(long)x){
            j=mid-1;
        }
        else if(mid*mid==x){
            return mid;
        }
        else{
            i=mid+1;
        }
       }
       return Math.round(j);
    }
}