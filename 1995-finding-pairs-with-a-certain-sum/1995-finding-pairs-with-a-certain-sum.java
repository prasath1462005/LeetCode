class FindSumPairs {
    int[] num1;
    int[] num2;
    HashMap<Integer,Integer> h=new HashMap<>();
    public FindSumPairs(int[] nums1, int[] nums2) {
        this.num1=nums1;
        this.num2=nums2;
        for(int n:num2)h.put(n,h.getOrDefault(n,0)+1);
        //System.out.println(h);
    }
    
    public void add(int index, int val) {
        int v=num2[index];
        h.put(v,h.get(v)-1);
        num2[index]=num2[index]+val;
        h.put(num2[index],h.getOrDefault(num2[index],0)+1);
        //for(int n:num2)System.out.println(n);
        //System.out.println(h);
    }
    
    public int count(int tot) {
        int ans=0;
        for(int n:num1){
            int v=tot-n;
            ans+=h.getOrDefault(v,0);
        }
        return ans;
    }
}

/**
 * Your FindSumPairs object will be instantiated and called as such:
 * FindSumPairs obj = new FindSumPairs(nums1, nums2);
 * obj.add(index,val);
 * int param_2 = obj.count(tot);
 */