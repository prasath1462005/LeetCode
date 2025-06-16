class Solution {
    List<List<Integer>> l=new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        gen(nums,new ArrayList<>(),0);
        return l;
    }
    public void gen(int[] n,List<Integer> ll,int i){
        if(i==n.length ){
            if(!l.contains(ll))l.add(ll);
            return;
        }
        List<Integer> pick=new ArrayList<>(ll);
        pick.add(n[i]);
        List<Integer> np=new ArrayList<>(ll); 
        gen(n,np,i+1);
        gen(n,pick,i+1);
    }
}