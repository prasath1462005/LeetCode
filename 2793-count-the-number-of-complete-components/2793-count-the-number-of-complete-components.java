class Solution {
    int[] vis;
    int nn = 0; 
    int e = 0;
    public int countCompleteComponents(int n, int[][] edges) {
        List<List<Integer>> l = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            l.add(new ArrayList<>());
        }
        int c = 0;
        for (int[] x : edges) {
            l.get(x[0]).add(x[1]);
            l.get(x[1]).add(x[0]);
        }
        vis = new int[n];
        for (int i = 0; i < n; i++) {
            if (vis[i] == 0) {
                nn = 0; 
                e = 0;
                dfs(i, l);
                if (e / 2 == (nn * (nn - 1)) / 2) { 
                    c++;
                }
            }
        }
        return c;
    }
    public void dfs(int x, List<List<Integer>> l) {
        vis[x] = 1;
        nn++;
        for (int x1 : l.get(x)) {
            e++; 
            if (vis[x1] == 0) { 
                dfs(x1, l);
            }
        }
    }
}
