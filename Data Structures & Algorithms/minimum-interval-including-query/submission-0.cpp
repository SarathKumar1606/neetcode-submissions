class Solution {
public:
    vector<int> minInterval(vector<vector<int>>& intervals, vector<int>& queries) {
       int n=queries.size();
        vector<int> qIndices(n);
        for(int i=0; i<n; i++){
            qIndices[i]=i;
        }
        vector<int> res(n);
        sort(qIndices.begin(), qIndices.end(),[&queries](const auto& a, const auto& b){
            return queries[a]<queries[b];
        });
        sort(intervals.begin(), intervals.end(),[](const auto& a, const auto& b){
            if(a[0]!=b[0]) return a[0]<b[0];
            return a[1]<b[1];

        });
        int intervalIndex=0;
        priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
        for(int i=0; i<n; i++){
            int query=queries[qIndices[i]];
            while(intervalIndex<intervals.size() && intervals[intervalIndex][0]<=query){
                int left=intervals[intervalIndex][0];
                int right=intervals[intervalIndex][1];
                int size=right-left+1;
                pq.push({size,right});
                intervalIndex++;
            }
            while(!pq.empty() && pq.top().second<query){
                pq.pop();
            }
            if(!pq.empty()){
                res[qIndices[i]]=pq.top().first;
            }else{
                res[qIndices[i]]=-1;
            }

        }
        return res; 
        
    }
};
