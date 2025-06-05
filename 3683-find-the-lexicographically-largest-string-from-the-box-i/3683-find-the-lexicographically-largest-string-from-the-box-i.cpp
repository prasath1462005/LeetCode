class Solution {
public:
    string answerString(string word, int numFriends) {
        if(numFriends==1)return word;
        int m=word.length()-numFriends+1;
        string s="";
        for(int i=0;i<word.length();i++){
            string t=word.substr(i,m);
            if(t>s)s=t;
        }
        return s;
    }
};