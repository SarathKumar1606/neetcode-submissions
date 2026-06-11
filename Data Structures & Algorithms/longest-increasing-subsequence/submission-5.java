class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        List<Integer> tails= new ArrayList<>();
        int len=0;
        for(int i=0; i<n; i++){
            int num=nums[i];
            if(tails.isEmpty() || num>tails.get(tails.size()-1)){
                tails.add(num);
                len++;
            }else{
                int left=0, right=tails.size()-1;
                while(left<=right){
                    int mid=(left+right)>>1;
                    if(tails.get(mid)<num){
                        left=mid+1;
                    }else{
                        right=mid-1;
                    }
                }
                tails.set(left,num);
            }
        }
        return len;
    }
}
