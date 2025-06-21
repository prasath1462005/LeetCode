class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> l=new ArrayList<>();
        helper(s,new ArrayList<>(),l,1);
        return l;
    }
    public void helper(String s,List<String> ll,List<List<String>> l,int cut){
        //System.out.println(s+" "+ll+" "+cut);
        if(s.isEmpty()){
            l.add(new ArrayList<>(ll));
            return;
        }
        if(cut>s.length())return;
        String p=s.substring(0,cut);
        if(pali(p)){
            ll.add(p);
            helper(s.substring(cut),ll,l,1);
            ll.remove(ll.size()-1);
        }
        helper(s,ll,l,cut+1);
    }
    public Boolean pali(String s){
        int l=0,r=s.length()-1;
        while(l<=r){
            if(s.charAt(l++)!=s.charAt(r--)){
                return false;
            }
        }
        return true;
    }
}