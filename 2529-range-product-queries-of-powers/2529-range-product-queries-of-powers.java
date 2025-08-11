class Solution {
    private static final long MOD = 1_000_000_007;

    public int[] productQueries(int n, int[][] queries) {
        int size = queries.length;
        int[] arr = new int[size];
        List<Integer> ll = new ArrayList<>();

        String s = Integer.toBinaryString(n);
        int i = 0;
        for (int j = s.length() - 1; j >= 0; j--) {
            if (s.charAt(j) == '1') {
                ll.add((int)((1L << i) % MOD)); // safer than Math.pow
            }
            i++;
        }

        Collections.sort(ll);
        List<Long> l = new ArrayList<>();
        l.add((long) ll.get(0));
        for (i = 1; i < ll.size(); i++) {
            l.add((l.get(i - 1) * ll.get(i)) % MOD);
        }

        i = 0;
        for (int[] nn : queries) {
            int l1 = nn[0];
            int r = nn[1];
            if (l1 != 0) {
                arr[i] = (int)((l.get(r) * modInverse(l.get(l1 - 1))) % MOD);
            } else {
                arr[i] = (int)(l.get(r) % MOD);
            }
            i++;
        }
        return arr;
    }

    private long modInverse(long a) {
        return powMod(a, MOD - 2); 
    }

    private long powMod(long base, long exp) {
        long res = 1;
        base %= MOD;
        while (exp > 0) {
            if ((exp & 1) == 1) res = (res * base) % MOD;
            base = (base * base) % MOD;
            exp >>= 1;
        }
        return res;
    }
}
