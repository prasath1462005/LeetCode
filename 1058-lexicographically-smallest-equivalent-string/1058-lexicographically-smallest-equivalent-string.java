class Solution {
    int[] rank;
    int[] par;
    public void disjoint(int n){
        rank=new int[n];
        par=new int[n];
        for(int i=0;i<n;i++){
            rank[i]=0;
            par[i]=i;
        }
    }
    public int par(int n){
        if(par[n] != n) {
            par[n] = par(par[n]); 
        }
        return par[n]; 
    }
    public void union(int u,int v){
        if(u==v)return ;
        int upar=par(u);
        int vpar=par(v);
        if(rank[upar]>rank[vpar] && upar<vpar){
            par[vpar]=upar;
        }
        else if(rank[vpar]>rank[upar] && vpar<upar){
            par[upar]=vpar;
        }
        else{
            if(upar<vpar){
                par[vpar]=upar;
                rank[upar]++;
            }
            else{
                par[upar]=vpar;
                rank[vpar]=rank[upar]+1;
            }
        }
    }
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        disjoint(26);
        for(int i=0;i<s1.length();i++){
            int u=s1.charAt(i)-'a';
            int v=s2.charAt(i)-'a';
            union(u,v);
        }
        StringBuilder s=new StringBuilder();
        for(int i=0;i<baseStr.length();i++){
            int p=par(baseStr.charAt(i)-'a');
            s.append((char)(p+97));
        }
        return s.toString();
    }
}