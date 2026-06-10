class Solution {
 
    public int numDecodings(String s) {
        int n=s.length();
        if(s.charAt(0)=='0') return 0;
        int[] dp= new int[n];
        dp[0]=1;
        if(s.charAt(1)!='0') dp[1]+=dp[0];
        int firstTwo=Integer.parseInt(s.substring(0,2));
        if(firstTwo>=10 && firstTwo<=26){
            dp[1]+=1;
        }
        for(int i=2; i<n; i++){
            if(s.charAt(i)!='0'){
                dp[i]+=dp[i-1];
            }
            int twoDigit=Integer.parseInt(s.substring(i-1,i+1));
            if(twoDigit>=10 && twoDigit<=26){
                dp[i]+=dp[i-2];
            }
        }
        return dp[n-1];
        
    }
}
