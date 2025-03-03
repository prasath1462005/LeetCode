class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        List<Integer> b=new ArrayList<>();
        List<Integer> m=new ArrayList<>();
        List<Integer> a=new ArrayList<>();
        for(int n:nums){
            if(n<pivot){
                b.add(n);
            }
            else if(n>pivot){
                a.add(n);
            }
            else{
                m.add(n);
            }
        }
        List<Integer> f=new ArrayList<>();
        f.addAll(b);
        f.addAll(m);
        f.addAll(a);
        int[] ans=f.stream().mapToInt(Integer::intValue).toArray();
        return ans;

    }
}