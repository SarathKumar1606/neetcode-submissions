class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> st= new HashSet<>();
        for(int i : nums){
            st.add(i);
        }
        int maxLen=0;
        for(int num : st){
            if(!st.contains(num-1)){
                int start=num;
                int len=1;
            
            while(st.contains(start+1)){
                start++;
                len++;
            }
            maxLen=Math.max(maxLen,len);
            }

        }
        return maxLen;
        
    }
}