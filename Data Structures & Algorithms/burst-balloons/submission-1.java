class Solution {   
    public int maxCoins(int[] nums) {
        int n=nums.length;
        int[] temp=new int[n+2];
        int[][] memo= new int[n+2][n+2];
        temp[0]=1;
        temp[n+1]=1;
        for(int i=1; i<n+1; i++) temp[i]=nums[i-1];
       for(int left=n;left>=0;left--){
        for(int right=left+2;right<n+2; right++){
            for(int k=left+1; k<right; k++){
                int currentCoins=temp[left]*temp[k]*temp[right];
                int total=memo[left][k]+memo[k][right]+currentCoins;
                memo[left][right]=Math.max(memo[left][right],total);
            }
        }
       }
       return memo[0][n+1];
        
    }
}
