class Solution {
public:
    string minWindow(string s, string t) {
        int l=0,r=0;
        unordered_map<char,int> tfq,wfq;
        for (char c : t) tfq[c]++;
        int have=0, need=tfq.size();
        int min_len=INT_MAX;
        int start_idx=0;
        while(true){
            if(have<need){
                if(r==s.size()) break;
                char cadd=s[r];
                wfq[cadd]++;
                if(wfq[cadd]==tfq[cadd]) have++;
                r++;
            }else{
                int curr_len=r-l;
                if(curr_len<min_len){
                    min_len=curr_len;
                    start_idx=l;
                }
                char crem=s[l];
                if(wfq[crem]==tfq[crem]){
                    have--;
                }
                wfq[crem]--;
                l++;
            }
        }
        return min_len==INT_MAX ? "" :s.substr(start_idx,min_len);
    }
};