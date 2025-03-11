class Solution {
    int a=0,e=0,i=0,o=0,u=0,c=0;
    public long countOfSubstrings(String word, int k) {
        int l=0;
        long count1=0,count2=0;
        for(int r=0;r<word.length();r++){
            if(word.charAt(r)=='a')a++;
            else if(word.charAt(r)=='e')e++;
            else if(word.charAt(r)=='i')i++;
            else if(word.charAt(r)=='o')o++;
            else if(word.charAt(r)=='u')u++;
            else c++;
            while(isok() && c>=k){
                count1+=(long)word.length()-r;
                if(word.charAt(l)=='a')a--;
                else if(word.charAt(l)=='e')e--;
                else if(word.charAt(l)=='i')i--;
                else if(word.charAt(l)=='o')o--;
                else if(word.charAt(l)=='u')u--;
                else c--;
                l++;
            }
            
        }
        System.out.println(count1);
        l=0;
        a=0;e=0;i=0;o=0;u=0;c=0;
        for(int r=0;r<word.length();r++){
            if(word.charAt(r)=='a')a++;
            else if(word.charAt(r)=='e')e++;
            else if(word.charAt(r)=='i')i++;
            else if(word.charAt(r)=='o')o++;
            else if(word.charAt(r)=='u')u++;
            else c++;
            while(isok() && c>=k+1){
                //System.out.println(count2+" "+l+" "+r);
                count2+=(long)word.length()-r;
                if(word.charAt(l)=='a')a--;
                else if(word.charAt(l)=='e')e--;
                else if(word.charAt(l)=='i')i--;
                else if(word.charAt(l)=='o')o--;
                else if(word.charAt(l)=='u')u--;
                else c--;
                l++;
            }
            
        }
        //System.out.println(count2);
        return count1-count2;
    }
    public boolean isok(){
        return a>0 && e>0 && i>0 && o>0 && u>0;
    }
}