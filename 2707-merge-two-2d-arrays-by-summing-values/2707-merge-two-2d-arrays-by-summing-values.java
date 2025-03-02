class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        TreeMap<Integer,Integer> h=new TreeMap<>();
        for(int i=0;i<nums1.length;i++){
            h.put(nums1[i][0],nums1[i][1]);

        }
        for(int i=0;i<nums2.length;i++){
            if(h.containsKey(nums2[i][0])){
                h.put(nums2[i][0],h.get(nums2[i][0])+nums2[i][1]);
            }
            else{
                h.put(nums2[i][0],nums2[i][1]);
            }
        }
        int[][] ans=new int[h.size()][2];
        int i=0;
        for(Map.Entry<Integer, Integer> entry : h.entrySet()){
            ans[i][0]=entry.getKey();
            ans[i][1]=entry.getValue();
            i++;
        }
        return ans;
    }
}