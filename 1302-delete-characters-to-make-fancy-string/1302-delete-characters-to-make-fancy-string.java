class Solution {
    public String makeFancyString(String s) {
        Stack<Character> st=new Stack<>();
        StringBuilder s1=new StringBuilder();
        for(char a:s.toCharArray()){
            if(!st.isEmpty() && st.peek()==a){
                st.push(a);
                continue;
            }
            int i=0;
            while(!st.isEmpty()){
                if(i<2){
                    s1.append(st.peek());
                }
                st.pop();
                i++;
            }
            st.push(a);
        } 
        int i=0;
        while(!st.isEmpty()){
            if(i<2){
                s1.append(st.peek());
            }
            st.pop();
            i++;
        }
        return s1.toString();
    }
}