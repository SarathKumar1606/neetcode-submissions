class Solution {
public:
    vector<int> maxSlidingWindow(vector<int>& nums, int k) {
        int l=0,r=0;
        int n=nums.size();
        vector<int> res;
        deque<int> dq;

        while(r<n){
            int curr=nums[r];
            while(!dq.empty() && nums[dq.back()]<curr){
                dq.pop_back();
            }
            dq.push_back(r);
            r++;
            if(r-l==k){
                res.push_back(nums[dq.front()]);
                if(dq.front()==l){
                    dq.pop_front();
                }
                l+=1;
            }

        }
        return res;
    }
};
