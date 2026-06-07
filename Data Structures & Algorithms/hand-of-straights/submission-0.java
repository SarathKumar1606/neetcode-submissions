class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        HashMap<Integer, Integer> freq= new HashMap<>();
        for(int i : hand)
            freq.put(i, freq.getOrDefault(i,0)+1);
        int[] temp = hand.clone();
        Arrays.sort(temp);
        int i=0;
        while(i<temp.length){
            int start=temp[i];
            if(freq.get(start)==0){
                i++;
                continue;
            }
              
            for(int j=i; j<=i+groupSize-1; j++){
                    int expected=start+(j-i);
                    int currfq=freq.getOrDefault(expected,0);
                    if(currfq>0){
                        currfq--;
                        freq.put(expected, currfq);
                    }else{
                        return false;
                    }
            }
            i++;
        }
        for(int count : freq.values()){
            if(count!=0){
                return false;
            }
        }
        return true;
        
    }
}
