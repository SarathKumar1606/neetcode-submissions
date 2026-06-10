class Solution {
    HashMap<String,Integer> mp=new HashMap<>();

    public boolean wordBreak(String s, List<String> wordDict) {
        for(String str:wordDict){
            mp.put(str,mp.getOrDefault(str,0)+1);
        }
        int n=s.length();
        boolean[] dp= new boolean[n+1];
        dp[0]=true;
        for(int i=1; i<=n; i++){
            for(int j=0; j<i; j++){
                if(dp[j]==true){
                    String curr=s.substring(j,i);
                    if(mp.containsKey(curr)){
                        dp[i]=true;
                        break;
                    }
                }
            }
        }
        return dp[n];
    }
}
