class Solution {
    public int maxFreeTime(int eventTime, int[] startTime, int[] endTime) {
        int n = startTime.length;
        int[] gap=new int[n+1];
        gap[0] = startTime[0];
        for (int i = 0; i < n - 1; i++) {
            gap[i + 1] = startTime[i + 1] - endTime[i];
        }
        gap[n] = eventTime - endTime[n - 1];
        int[] l=new int[n+1];
        int[] r=new int[n+1];
        for(int i=n-1;i>=0;i--){
            l[i]=Math.max(l[i+1],gap[i+1]);
        }
        for(int i=2;i<n+1;i++){
            r[i]=Math.max(r[i-1],gap[i-2]);
        }
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            int curr=endTime[i-1]-startTime[i-1];
            //System.out.println(curr+" "+l[i]+" "+r[i]);
            if (curr<= Math.max(r[i], l[i])) {
                ans = Math.max(ans, gap[i - 1] + gap[i] + curr);
            }
            ans = Math.max(ans, gap[i - 1] + gap[i]);
        }
        return ans;
    }
}