class Solution {
    public int maxOperations(String s) {
        int ones = 0;
        int[] numberOfOnes = new int[s.length()];
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '0'){
                numberOfOnes[i] = ones;
            }
            else ones ++;
        }

        int sum = 0;
        for(int i = s.length()-1 ;i >= 0 ; i--){
            if(s.length()-1 == i)sum+=numberOfOnes[i];
            else if(s.charAt(i+1)=='1' && s.charAt(i)=='0'){
                sum+=numberOfOnes[i];
            }
        }

        return sum;
    }
}