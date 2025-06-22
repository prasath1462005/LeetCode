class Solution {
    public String[] divideString(String s, int k, char fill) {
        int n=s.length()/k;
        int n1=s.length()%k!=0?1:0;
        //System.out.println(n+" "+n1);
        String[] ss=new String[n+n1];
        int j=0;
        int i;
        for(i=0;i<s.length();i+=k){
            if(i+k>s.length())break;
            String ne=s.substring(i,i+k);
            ss[j++]=ne;

        }
        String ne="";
        while(i<s.length()){
            ne+=s.charAt(i);
            i++;
        }
        while(ne.length()<k){
            ne+=fill;
        }
        if(j<ss.length)
        ss[j]=ne;
        return ss;
    }
}