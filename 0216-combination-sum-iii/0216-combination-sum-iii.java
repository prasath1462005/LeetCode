class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> l=new ArrayList<>();
        allcombo(1,k,n,l,new ArrayList<>());
        return l;
    }
    public void allcombo(int s,int k,int n,List<List<Integer>> l,List<Integer> ll){
        if(n<0 || k<0)return;
        if(n==0 && k==0)l.add(new ArrayList<>(ll));
        for(int i=s;i<=9;i++){
            if(n-i<0)break;
            ll.add(i);
            allcombo(i+1,k-1,n-i,l,ll);
            ll.remove(ll.size()-1);
        }
    }
}