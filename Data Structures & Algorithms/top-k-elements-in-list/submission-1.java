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
        PriorityQueue<Integer> pq= new PriorityQueue<>((a,b)->mp.get(b)-mp.get(a));//b is parent and a is new node
        for(int num : mp.keySet()){
            pq.add(num);
            
        }
        int[] result=new int[k];
        for(int i=0; i<k;i++){
            result[i]=pq.poll();
        }
        return result;
        
        
        
    }
}
