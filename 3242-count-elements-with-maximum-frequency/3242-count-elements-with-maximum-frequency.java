class Solution {
    public int maxFrequencyElements(int[] nums) {
        HashMap<Integer,Integer> h=new HashMap<>();
        for(int i:nums){
            h.put(i,h.getOrDefault(i,0)+1);
        }
        //System.out.println(h);
        int max=0;
        HashMap<Integer,Integer> hh=new HashMap<>();
        for(int i:h.keySet()){
            max=Math.max(max,h.get(i));
        }
        int c=0;
        for(int i:h.keySet()){
            if(h.get(i)==max)c++;
        }
        System.out.println(c*max);
        return max*c;
    }
}