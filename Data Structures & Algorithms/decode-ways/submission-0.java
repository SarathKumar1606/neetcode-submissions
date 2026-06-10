class Solution {
    HashMap<Integer,Integer> memo = new HashMap<>();
    int dp(int i, String s, int n){
        if(i==n) return 1;
        if(s.charAt(i)=='0') return 0;
        if(memo.containsKey(i)){
            return memo.get(i);
        }
        int res=dp(i+1,s,n);
        if(i+1<n){
            int twoDigit=Integer.parseInt(s.substring(i,i+2));
            if(twoDigit>=10 && twoDigit<=26){
                res+=dp(i+2,s,n);
            }
        }
        memo.put(i,res);
        return res;
    }
    public int numDecodings(String s) {
        memo.clear();
        int n=s.length();
        int count=0;
        return dp(0,s,n);
        
    }
}
