class Solution {
    int[][] dp;

    public int countSquares(int[][] matrix) {
        dp = new int[matrix.length][matrix[0].length];
        for (int[] n : dp)
            Arrays.fill(n, -1);
        int res = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                res += c(i, j, matrix);
            }
        }
        return res;
    }

    int c(int i, int j, int[][] m) {
        if (i >= m.length || j >= m[0].length)
            return 0;
        if (m[i][j] == 0)
            return 0;
        if (dp[i][j] != -1)
            return dp[i][j];
        int n = c(i, j + 1, m);
        int diagnol = c(i + 1, j + 1, m);
        int down = c(i + 1, j, m);
        dp[i][j] = 1 + Math.min(n, Math.min(diagnol, down));
        return dp[i][j];
    }
}