class Solution {
    public int candy(int[] ratings) {
        int i,l=ratings.length,sum=0;
        int []arr=new int[l];
        arr[0]=1;
        for(i=1;i<l;i++){
            if(ratings[i]>ratings[i-1]){
                arr[i]=arr[i-1]+1;
            }
            else{
                arr[i]=1;
            }
        }
        for(i=l-2;i>=0;i--){
            if(i==0 ){
                if(ratings[i]>ratings[i+1]){
                    arr[i]=arr[i+1]+1;
                }
                break;
            }
            if(ratings[i]>ratings[i+1] ){
                if(arr[i]<=arr[i+1])
                arr[i]=arr[i+1]+1;
            }
        }
        for(i=0;i<l;i++){
            sum+=arr[i];
        }
        return sum;
    }
}