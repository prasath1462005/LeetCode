class Solution {
public:
    int longestSubstring(string s, int k) {
        int unichar=mu(s);
        vector<int> freq(26,0);
        int m=0;
        for(int i=1;i<=unichar;i++){
            fill(freq.begin(),freq.end(),0);
            int countuni=0,ws=0,we=0,atk=0;
            while(we<s.length()){
                if(countuni<=i){
                    int idx=s[we]-'a';
                    if(freq[idx]==0){
                        countuni++;
                    }
                    freq[idx]++;
                    if(freq[idx]==k)atk++;
                    we++;
                }
                else{
                    int idx=s[ws]-'a';
                    if(freq[idx]==k)atk--;
                    freq[idx]--;
                    if(freq[idx]==0)countuni--;
                    ws++;
                }
                if(countuni==i && countuni==atk)m=max(m,we-ws);
            }
        }
        return m;
    }
    int mu(string s){
        vector<bool> chars(26,false);
        int maxu=0;
        for(auto a:s){
            if(!chars[a-'a']){
                chars[a-'a']=true;
                maxu++;
            }
        } 
        return maxu;
    }
};