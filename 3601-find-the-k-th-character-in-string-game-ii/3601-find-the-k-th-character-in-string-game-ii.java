class Solution {
    public char kthCharacter(long k, int[] operations) {
        int val=kk(k,operations);
        System.out.println(val);
        return (char)(val+'a');
    }
    public int kk(long num,int[] op){
        if(num<=1)return 0;
        double log2=Math.log(num) / Math.log(2);
        long po=(long)Math.ceil(log2);
        int tp=(int)(po);
        po=num-(long)Math.pow(2,po-1);
        return (int)(kk(po,op)+op[tp-1])%26;
    }
}