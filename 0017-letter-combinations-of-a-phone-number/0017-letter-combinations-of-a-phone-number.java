class Solution {
    public List<String> letterCombinations(String digits) {
        String[] ph=new String[]{"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        List<String> l=new ArrayList<>();
        if(digits.length()==0)return l;
        allcombo(new StringBuilder(),ph,digits,0,l);
        return l;
    }
    public void allcombo(StringBuilder s,String[] ph,String d,int i,List<String> l){
        if(i==d.length()){
            l.add(s.toString());
            return ;
        }
        int ii=(int)(d.charAt(i)-'2');
        for(char c:ph[ii].toCharArray()){
            s.append(c);
            allcombo(s,ph,d,i+1,l);
            s.deleteCharAt(s.length()-1);
        }
    }
}