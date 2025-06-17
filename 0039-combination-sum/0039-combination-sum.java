class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> l=new ArrayList<>();
        allcombo(candidates,target,0,0,l,new ArrayList<>());
        return l;
    }
    public void allcombo(int[] p,int t,int i,int val,List<List<Integer>> l,List<Integer> ll){
       // System.out.println(val+" "+ll);
        if(val>t)return ;
        if(val==t){
            l.add(new ArrayList<>(ll));
            return;
        }
        int ind=i;
        for(;ind<p.length;ind++){
            ll.add(p[ind]);
            allcombo(p,t,ind,val+p[ind],l,ll);
            ll.remove(ll.size()-1);
        }
    }
}