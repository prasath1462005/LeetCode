class Solution {
    public int largestRectangleArea(int[] heights) {
        int[] nse=new int[heights.length];
        int[] pse=new int[heights.length];
        fnse(nse,heights);
        fpse(pse,heights);
        int max=0;
        for(int i=0;i<nse.length;i++){
            max=Math.max(max,heights[i]*(nse[i]-pse[i]-1));
        }
        return max;
    }
    public void fnse(int[] arr,int[] h){
        int i=h.length-1;
        Stack<Integer> s=new Stack<>();
        for(;i>=0;i--){
            while(!s.isEmpty() && h[s.peek()]>=h[i]){
                s.pop();
            }
            arr[i]=s.isEmpty()?h.length:s.peek();
            s.push(i);
            System.out.println(s);
        }
    }
    public void fpse(int[] arr,int[] h){
        int i=0;
        Stack<Integer> s=new Stack<>();
        for(;i<h.length;i++){
            while(!s.isEmpty() && h[s.peek()]>=h[i]){
                s.pop();
            }
            arr[i]=s.isEmpty()?-1:s.peek();
            s.push(i);
        }
    }
}