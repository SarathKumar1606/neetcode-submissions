class Solution {
public:
    vector<int> maxSlidingWindow(vector<int>& nums, int k) {
        int l=0,r=0;
        int n=nums.size();
        vector<int> res;
        priority_queue<pair<int,int>> max_heap;

        while(r<n){
            int curr=nums[r];
            max_heap.push({nums[r],r});
            r++;
            if(r-l==k){
                while(!max_heap.empty() && max_heap.top().second<l){
                    max_heap.pop();
                }
                res.push_back(max_heap.top().first);
                l+=1;
            }

        }
        return res;
    }
};
