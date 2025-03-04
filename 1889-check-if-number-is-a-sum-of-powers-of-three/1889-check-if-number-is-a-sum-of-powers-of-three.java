class Solution {
    public boolean checkPowersOfThree(int n) {
        List<Integer> l=new ArrayList<>();
        int n1=n;
        for(int i=0;i<=16;i++){
            l.add((int)Math.pow(3,i));
        }
        int i=l.size()-1;
        while(i>=0){
            if(l.get(i)<=n){
                n-=l.get(i);
            }
            i--;
            if(n==0)return true;
        }
        //System.out.print(l);
        return false;
    }
}