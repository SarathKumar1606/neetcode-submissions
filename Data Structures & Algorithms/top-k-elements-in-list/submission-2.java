class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> mp = new HashMap<>();
        for(int i : nums){
            mp.put(i,mp.getOrDefault(i,0)+1);     
        }
        List<Integer>[] bucket =new List[nums.length+1];
        for(int num : mp.keySet()){
            int freq=mp.get(num);
            if(bucket[freq]==null){
                bucket[freq]=new ArrayList<>();
            }
            bucket[freq].add(num);
        }
        int[] result=new int[k];
        int index=0;
        for(int i=bucket.length-1; i>=0 && index<k; i--){
            if(bucket[i]!=null){
                for(int num : bucket[i]){
                    result[index++]=num;
                    if(index==k) return result;
                }
            }
        }
        return result;
        
        
        
    }
}
