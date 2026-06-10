class Solution {
    public String expandAroundCenter(String s, int left, int right){
        while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
            left--;
            right++;
        }
        return s.substring(left+1,right);
    }
    public String longestPalindrome(String s) {
        int n = s.length();
        if (n == 1)
            return s;
        String longest="";
        for(int i=0; i<n; i++){
            String odd=expandAroundCenter(s,i,i);
            String even=expandAroundCenter(s,i,i+1);
            if(odd.length()>longest.length()) longest=odd;
            if(longest.length()<even.length()) longest=even;
        }
        return longest;
    }
}
