class Solution {
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        int r=x,c=y;
        int er=x+k-1;
        for(int i=r;i<er;i++){
            for(int j=c;j<y+k;j++){
                int temp=grid[i][j];
                //System.out.println(temp+" "+grid[er][j]);
                grid[i][j]=grid[er][j];
                grid[er][j]=temp;
            }
            er--;
        }
        return grid;
    }
}