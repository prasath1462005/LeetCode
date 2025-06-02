class Solution {
    public int snakesAndLadders(int[][] board) {
        int n=board.length;
        Queue<Integer> q=new LinkedList<>();
        int[][] v=new int[n][n];
        q.add(1);
        v[n-1][0]=1;
        int step=0;
        while(!q.isEmpty()){
            int size=q.size();
            while(size>0){
                int curr=q.poll();
                if(curr==n*n)return step;
                for(int i=1;i<=6;i++){
                    if(curr+i>n*n)continue;
                    int[] pos=rc(i+curr,n);
                    int r=pos[0];
                    int c=pos[1];
                    if(v[r][c]==1)continue;
                    if(board[r][c]==-1)q.add(curr+i);
                    else q.add(board[r][c]);
                    v[r][c]=1;
                }
                size--;
            }
            step++;
        }
        return -1;
    }
    public int[] rc(int num,int N){
        int row = N - 1 - (num - 1) / N;
        boolean isEvenFromBottom = ((num - 1) / N) % 2 == 0;
        int col;

        if (isEvenFromBottom) {
            col = (num - 1) % N;
        } else {
            col = N - 1 - (num - 1) % N;
        }

        return new int[]{row, col};
    }
}