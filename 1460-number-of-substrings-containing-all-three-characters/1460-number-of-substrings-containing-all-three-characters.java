class Solution {
    int[] hold=new int[3];
    public int numberOfSubstrings(String s) {
        int cc=0;
        int st=0;
        for(int e=0;e<s.length();e++){
            hold[s.charAt(e)-'a']++;
            while(isok()){
                cc+=s.length()-e;
                hold[s.charAt(st++)-'a']--;
            }
        }
        return cc;
    }
    public boolean isok(){
        for(int h:hold){
            if(h==0)return false;
        }
        return true;
    }
}