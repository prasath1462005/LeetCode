class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        List<Integer> l=new ArrayList<>();
        int r=0,c=0;
        int row=mat.length;
        int col=mat[0].length;
        //System.out.println(row+" "+col);
        while(r<mat.length-1 || c<mat[0].length-1){
            l.add(mat[r][c]);
            //System.out.println(l);
            while(r-1>=0 && c+1<col){
                l.add(mat[r-1][c+1]);
                r--;c++;
                //System.out.println("hiin"+r+" "+c);
            }
            if(c+1<col){
                c=c+1;
            }
            else if(r+1<row){
                r=r+1;
            }
            //System.out.println(l);
            l.add(mat[r][c]);
            while(r+1<row && c-1>=0){
                l.add(mat[r+1][c-1]);
                r++;c--;
                //System.out.println("hi2in"+r+" "+c);
            }
            if(r+1<row){
                r=r+1;
            }
            else if(c+1<col){
                c=c+1;
            }
            //System.out.println(l);
        }
        l.add(mat[r][c]);
        int[] ans=new int[row*col];
        int i;
        //System.out.println(ans.length+" "+l.size());
        for(i=0;i<row*col;i++){
            //System.out.println(l.get(i));
            ans[i]=l.get(i);
        }
        return ans;
    }
}