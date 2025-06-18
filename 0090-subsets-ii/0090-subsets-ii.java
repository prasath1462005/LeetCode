class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Set<List<Integer>> l=new HashSet<>();
        Arrays.sort(nums);
        allcombo(nums,0,l,new ArrayList<>());
        List<List<Integer>> ll=new ArrayList<>(l);
        return ll;
    }
    public void allcombo(int[] n,int s,Set<List<Integer>> l,List<Integer> ll){
        if(s>n.length)return;
        l.add(new ArrayList<>(ll));
        for(int i=s;i<n.length;i++){
            ll.add(n[i]);
            allcombo(n,i+1,l,ll);
            ll.remove(ll.size()-1);
        }
    }
}