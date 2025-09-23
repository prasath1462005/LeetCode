class Solution {
    public int compareVersion(String version1, String version2) {
        String[] s=version1.trim().split("\\.");
        String[] s2=version2.trim().split("\\.");
        int m=Math.max(s.length,s2.length);
        for(int i=0;i<m;i++){
            int v1=i<s.length?Integer.parseInt(s[i]):0;
            int v2=i<s2.length?Integer.parseInt(s2[i]):0;
            //System.out.println(v1+" "+v2);
            if(v1==v2)continue;
            if(v1<v2)return -1;
            else return 1;
        }

        return 0;
    }
}