class Solution {
    private int expandAroundCenter(String s, int left, int right){
        int subcount=0;
        while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
            subcount++;
            left--;
            right++;
        }
        return subcount;
    }
    public int countSubstrings(String s) {
        int n=s.length();
        if(n==1) return 1;
       int count=0;
       for(int i=0; i<s.length(); i++){
        count+=expandAroundCenter(s,i,i);
        count+=expandAroundCenter(s,i,i+1);
       }
       return count;    
    }
}
