class Solution {
    public char kthCharacter(int k) {
        StringBuilder s=new StringBuilder();
        s.append('a');
        while(s.length()<=k){
            String ss=new String(s.toString());
            for(int i=0;i<ss.length();i++){
                s.append((char)((((ss.charAt(i)-'a')+1)%26)+'a'));
            }
            System.out.println(s);
        }
        return s.charAt(k-1);
    }
}