class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> l=new ArrayList<>();
       Arrays.sort(candidates);
       allcombo(candidates,target,0,l,new ArrayList<>()); 
       return l;
    }
    public void allcombo(int[] p,int t,int i,List<List<Integer>> l,List<Integer> ll){
        //System.out.println(val+" "+ll);
        if(t==0){
            l.add(new ArrayList<>(ll));
            return;
        }
        for(int s=i;s<p.length;s++){
            if(s>i && p[s]==p[s-1])continue;
            if(p[s]>t)break;
            ll.add(p[s]);
            allcombo(p,t-p[s],s+1,l,ll);
            ll.remove(ll.size()-1);
        }
    }
}