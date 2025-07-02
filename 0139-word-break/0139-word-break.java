class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> sst=new HashSet<>(wordDict);
        Boolean[] memo=new Boolean[s.length()];
        return ch(s,sst,memo,0);
    }
    public boolean ch(String s,Set<String> w,Boolean[] memo,int st){
        if(s.length()==st)return true;
        if(memo[st]!=null)return memo[st];
        for(int end=st+1;end<=s.length();end++){
            String sub=s.substring(st,end);
            if(w.contains(sub) && ch(s,w,memo,end)){
                return memo[st]=true;
            }
        }
        return memo[st]=false;
    }
}