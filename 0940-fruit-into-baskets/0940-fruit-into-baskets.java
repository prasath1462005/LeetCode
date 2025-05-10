class Solution {
    public int totalFruit(int[] fruits) {
        HashMap<Integer,Integer> h=new HashMap<>();
        int l=0,r,maxlen=0;
        for(r=0;r<fruits.length;r++){
            if(!h.containsKey(fruits[r]))h.put(fruits[r],1);
            else h.put(fruits[r],h.get(fruits[r])+1);
            while(h.size()>2){
                //System.out.println("hi");
                if(h.get(fruits[l])==1)h.remove(fruits[l]);
                else h.put(fruits[l],h.get(fruits[l])-1);
                l++;
            }
            maxlen=Math.max(maxlen,r-l+1);
        }
        return maxlen;
    }
}