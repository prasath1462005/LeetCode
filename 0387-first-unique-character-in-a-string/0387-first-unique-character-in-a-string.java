class Solution {
    public int firstUniqChar(String s) {
        int count=0;
        for(int i = 0 ; i<s.length() ; i++){
            count =0;
for(int j = 0;j<s.length();j++){
    if(s.charAt(i)==s.charAt(j)){
        count++;
        if(count==2)
        break;
    }
}
if(count==1){
    return i;
}

        }
        return -1;
    }
}