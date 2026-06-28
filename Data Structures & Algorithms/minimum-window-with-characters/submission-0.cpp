class Solution {
public:
    string minWindow(string s, string t) {
        int l=0, r=0;
        unordered_map<char,int> tfq;
        for(char c : t) tfq[c]++;
        int n=s.size();
        int start=0, minLen=INT_MAX, required=t.size();
        while(r<n){
           if(tfq[s[r]]>0){
            required--;
           }
           tfq[s[r]]--;
           r++;
            while(required==0){
                if(r-l<minLen){
                    minLen=r-l;
                    start=l;
                }
                tfq[s[l]]++;
                if(tfq[s[l]]>0) required++;

                l++;
            }
        }
        return minLen==INT_MAX? "":s.substr(start,minLen);
        
    }
};
