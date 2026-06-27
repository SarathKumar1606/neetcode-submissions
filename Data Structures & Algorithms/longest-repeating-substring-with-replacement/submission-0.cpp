class Solution {
public:
    int characterReplacement(string s, int k) {
         int l=0,r=0;
        int n=s.size();
        vector<int> count(26,0);
        int curr_max=0;

        while(r<n){
            int window_len=(r-l+1);
            int matching_chars=count[s[l]-'A']+(s[r]==s[l]? 1:0);
            bool can_grow=(window_len-matching_chars<=k);
            if(can_grow){
                count[s[r]-'A']++;
                r+=1;
                curr_max=max(curr_max,r-l);
            }else if(l==r){
                l+=1;
                r+=1;
            }else{
                count[s[l]-'A']--;
                l+=1;
            }
        }
        return curr_max;
    }
};
