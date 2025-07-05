class Solution {
    public int findLucky(int[] arr) {
        HashMap<Integer,Integer> h=new HashMap<>();
        Set<Integer> s=new HashSet<>();
        for(int i=0;i<arr.length;i++){
            h.put(arr[i],h.getOrDefault(arr[i],0)+1);
            s.add(arr[i]);
        }
        int ans=-1;
        for(int n:s){
            if(n==h.get(n) && n>ans)ans=n;
        }
        return ans;
    }
}