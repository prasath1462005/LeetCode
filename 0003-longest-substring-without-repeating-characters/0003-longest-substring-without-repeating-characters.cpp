class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        map<char,int> m;
        int maxlen=0,i=0;
        for(int j=0;j<s.length();j++){
            if (m.find(s[j]) != m.end() && m[s[j]] >= i) {
                i = m[s[j]] + 1;
            }
            m[s[j]] = j; 
            maxlen = max(maxlen, j - i + 1);
        }
        return maxlen;
    }
};