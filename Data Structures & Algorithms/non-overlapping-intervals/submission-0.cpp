class Solution {
public:
    int eraseOverlapIntervals(vector<vector<int>>& intervals) {
        int n =intervals.size();
        sort(intervals.begin(), intervals.end(),[](auto a, auto b){
            return a[1]<b[1];
        });
        int end=intervals[0][1];
        int i=1;
        int count=0;
        while(i<n){
            if(intervals[i][0]<end){
                count++;
            }else{
                end=intervals[i][1];
            }
            i++;
        }
        return count;
        
        
    }
};
