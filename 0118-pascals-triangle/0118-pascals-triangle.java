class Solution {
    public List<List<Integer>> generate(int nu) {
        List<List<Integer>> l=new ArrayList<>();
        return check(l,nu);    
    }
    public List<List<Integer>> check(List<List<Integer>> li,int n){
        if(n==0)return li;
        List<Integer> in=new ArrayList<>();
        if(n==1){
            in.add(1);
            li.add(in);
            return li;
        }
        check(li,n-1);
        int i;
        in.add(1);
        if(n>1){
            List<Integer> lo=li.get(li.size()-1);
            for(i=1;i<lo.size();i++){
                in.add(lo.get(i-1)+lo.get(i));
            }
        }
        in.add(1);
        li.add(in);
        return li;
    }
}