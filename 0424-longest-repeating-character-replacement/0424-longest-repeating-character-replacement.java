class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq=new int[26];
        int max=0,maxf=0,l=0,r=0;
        while(r<s.length()){
            freq[s.charAt(r)-'A']++;
            maxf=Math.max(maxf,freq[s.charAt(r)-'A']);
            while((r-l+1)-maxf>k){
                freq[s.charAt(l++)-'A']--;
                for(int i=0;i<26;i++){
                    maxf=Math.max(maxf,freq[i]);
                }
            }
            if((r-l+1)-maxf<=k){
                max=Math.max(r-l+1,max);
            }
            r++;
        }
        return max;
    }
}