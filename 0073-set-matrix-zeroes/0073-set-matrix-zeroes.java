class Solution {
    public void setZeroes(int[][] matrix) {
        int[] r=new int[matrix.length];
        int[] c=new int[matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==0){
                    r[i]++;c[j]++;
                }
            }
        }
        for(int i=0;i<r.length;i++){
            if(r[i]>0){
                for(int j=0;j<matrix[0].length;j++){
                    matrix[i][j]=0;
                }
            }
        }
        for(int i=0;i<c.length;i++){
            if(c[i]>0){
                for(int j=0;j<matrix.length;j++){
                    matrix[j][i]=0;
                }
            }
        }
    }
}