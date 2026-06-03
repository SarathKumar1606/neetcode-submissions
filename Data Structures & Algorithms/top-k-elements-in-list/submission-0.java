class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> mp = new HashMap<>();
        for(int i : nums){
            if(mp.containsKey(i)){
                int freq=mp.get(i);
                mp.put(i,++freq);
            }else{
                mp.put(i,1);
            }
        }
        List<Integer> ans= new ArrayList<>();
        int n=0;
        for(Map.Entry<Integer,Integer> entry : mp.entrySet()){
            int key=entry.getKey();
            int val=entry.getValue();
            if(val>=k){
                ans.add(key);
                n++;
            }
        }
        int[] res= new int[n];
        for(int i=0;i<n; i++){
            res[i]=ans.get(i);
        }
        return res;
        
    }
}
