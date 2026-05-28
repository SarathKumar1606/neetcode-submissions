class Solution {
public:
    vector<vector<int>> merge(vector<vector<int>>& intervals) {
        sort(intervals.begin(),intervals.end(),[](auto a, auto b){
            return a[0]<b[0];
        });
        vector<vector<int>> res;
        int i=1, n=intervals.size();
        auto prev=intervals[0];
        while(i<n){
            auto curr=intervals[i];
            if(curr[0]<=prev[1]){
                prev[1]=max(prev[1],curr[1]);
            }else{
                res.push_back(prev);
            prev=curr;
            }
            i++;
        }
        res.push_back(prev);
         return res;
    }
};
