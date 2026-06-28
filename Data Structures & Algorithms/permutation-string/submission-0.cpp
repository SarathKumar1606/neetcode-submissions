class Solution {
public:
    bool checkInclusion(string s1, string s2) {
        int l=0, r=0;
        int n=s2.size();
        int m=s1.size();
        vector<int> s1fq(26,0);
        for(char c : s1) s1fq[c-'a']++;
        vector<int> s2fq(26,0);
        while(r<n){
            s2fq[s2[r]-'a']++;
            r++;
            if( r-l==m){
                if(s1fq==s2fq){
                    return true;
                }
                s2fq[s2[l]-'a']--;
                l++;
            }

        }
        return false;
        
    }
};
