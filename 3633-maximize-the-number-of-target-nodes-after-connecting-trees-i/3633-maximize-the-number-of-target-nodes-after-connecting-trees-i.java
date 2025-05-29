class Solution {
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
        int n1 = edges1.length + 1;
        int n2 = edges2.length + 1;
        List<List<Integer>> adj = new ArrayList<>();
        List<List<Integer>> adj2 = new ArrayList<>();
        for (int i = 0; i < n1; i++) adj.add(new ArrayList<>());
        for (int i = 0; i < n2; i++) adj2.add(new ArrayList<>());
        for (int[] it : edges2) {
            adj2.get(it[0]).add(it[1]);
            adj2.get(it[1]).add(it[0]);
        }
        for (int[] it : edges1) {
            adj.get(it[0]).add(it[1]);
            adj.get(it[1]).add(it[0]);
        }

        int t2_hop = 0;
        for (int i = 0; i < n2; i++) {
            t2_hop = Math.max(t2_hop, bfs(k - 1, adj2, i, n2));
        }

        int[] result = new int[n1];
        for (int i = 0; i < n1; i++) {
            int temp = bfs(k, adj, i, n1);
            result[i] = temp + t2_hop;
        }

        return result;
    }

    private int bfs(int k, List<List<Integer>> tree, int value, int n) {
        boolean[] visited = new boolean[n];
        Queue<int[]> q = new LinkedList<>();
        int cnt = 0;

        if (k < 0) return 0;

        q.add(new int[]{value, k});
        visited[value] = true;

        while (!q.isEmpty()) {
            int[] front = q.poll();
            int node = front[0];
            int val = front[1];

            cnt++;

            if (val <= 0) continue;

            for (int neighbor : tree.get(node)) {
                if (!visited[neighbor]) {
                    q.add(new int[]{neighbor, val - 1});
                    visited[neighbor] = true;
                }
            }
        }

        return cnt;
    }
}
