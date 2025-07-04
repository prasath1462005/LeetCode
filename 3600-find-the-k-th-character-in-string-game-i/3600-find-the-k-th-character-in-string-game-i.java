class Solution {
    public char kthCharacter(int k) {
        return (char)(kk(k)+'a');
    }
    public int kk(int num){
        if(num<=1)return 0;
        double log2=Math.log(num) / Math.log(2);
        int po=(int)Math.ceil(log2);
        return (kk(num-(int)Math.pow(2,po-1))+1)%26;
    }
}