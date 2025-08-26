class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> s=new Stack<>();
        int max=0;
        for(int i=0;i<heights.length;i++){
            while(!s.isEmpty() && heights[i]<heights[s.peek()]){
                int right=i;
                int curr=s.pop();
                int left=s.isEmpty()?-1:s.peek();
                //System.out.println(left+" "+right);
                max=Math.max(max,heights[curr]*(i-left-1));
                //System.out.println(max);
            }
            s.push(i);
            //System.out.println(s);
        }
        while(!s.isEmpty()){
            int curr = s.pop();
            int left = s.isEmpty() ? -1 : s.peek();
            max = Math.max(max, heights[curr] * (heights.length - left - 1));
        }
        return max;
    }
}