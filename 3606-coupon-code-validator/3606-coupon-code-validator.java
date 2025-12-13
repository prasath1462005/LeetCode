class Solution {
    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        
        PriorityQueue<String[]> valid = new PriorityQueue<>(
            new Comparator<String[]>() {
                @Override
                public int compare(String[] a, String[] b) {
        
                    int businessLineComparison = a[0].compareTo(b[0]);
                    
                    if (businessLineComparison != 0) {
                        return businessLineComparison;
                    } else {

                        return a[1].compareTo(b[1]);
                    }
                }
            }
            
        );
        for(int i = 0 ; i < code.length ;i++){
            if(checkString(code[i]) && (businessLine[i].equals("electronics") || businessLine[i].equals("grocery") 
            || businessLine[i].equals("pharmacy") || businessLine[i].equals("restaurant") ) && isActive[i]){
                valid.add(new String[]{businessLine[i],code[i]});
            }
        }
        List<String> l = new ArrayList<>();
        while(!valid.isEmpty()){
            String[] s = valid.poll();
            l.add(s[1]); 
        }
        
       
        return l;

    }
    public boolean checkString(String code){

        if(code.length() ==0)return false;
        for(int i = 0; i < code.length(); i++){
            if((code.charAt(i) >= 65 &&  code.charAt(i) <=90) || (code.charAt(i) >= 97 &&  code.charAt(i) <= 122) || 
            (code.charAt(i) >= 48 &&  code.charAt(i) <= 57) || (code.charAt(i) == '_')){
                continue;
            }
            else{
                return false;
            }
        }
        return true;

    }
}