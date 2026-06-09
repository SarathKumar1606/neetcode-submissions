class Solution {
    public List<Integer> partitionLabels(String s) {
        HashMap<Character,Integer> freq = new HashMap<>();
        for(char c : s.toCharArray()){
                freq.put(c,freq.getOrDefault(c,0)+1);
        }
        List<Integer> res = new ArrayList<>();
        HashMap<Character, Integer> currWindowFreq= new HashMap<>();
        int activeCharCount=0;
        int currSize=0;
        for(int i=0; i<s.length(); i++){
            char curr=s.charAt(i);
            currSize++;
            
            if(!currWindowFreq.containsKey(curr)){
                currWindowFreq.put(curr,freq.get(curr));
                activeCharCount++;
            }
            currWindowFreq.put(curr,currWindowFreq.get(curr)-1);

            if(currWindowFreq.get(curr)==0){
                activeCharCount--;
            }

            if(activeCharCount==0){
                res.add(currSize);
                currSize=0;
                currWindowFreq.clear();
            }

        
        }
        return res;
        
    }
}
