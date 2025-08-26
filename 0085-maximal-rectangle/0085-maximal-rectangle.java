class Solution {
    public int maximalRectangle(char[][] matrix) {
        int[] arr=new int[matrix[0].length];
        int max=0;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]=='1'){
                    arr[j]=arr[j]+1;
                }
                else {
                    arr[j]=0;
                }
            }
            max=Math.max(max,histo(arr));
        }
        return max;
    }
    public int histo(int[] heights){
        Stack<Integer> s=new Stack<>();
        int max=0;
        for(int i=0;i<heights.length;i++){
            while(!s.isEmpty() && heights[i]<heights[s.peek()]){
                int right=i;
                int curr=s.pop();
                int left=s.isEmpty()?-1:s.peek();
                max=Math.max(max,heights[curr]*(i-left-1));
            }
            s.push(i);
        }
        while(!s.isEmpty()){
            int curr = s.pop();
            int left = s.isEmpty() ? -1 : s.peek();
            max = Math.max(max, heights[curr] * (heights.length - left - 1));
        }
        return max;
    }
}