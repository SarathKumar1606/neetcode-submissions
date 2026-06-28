class Solution {
public:
    vector<int> maxSlidingWindow(vector<int>& nums, int k) {
        int l=0,r=0;
        int n=nums.size();
        vector<int> res;
        int currwinmax=INT_MIN;
        int currwinmaxidx=-1;
        while(r<n){
            int curr=nums[r];
            if(currwinmax<curr){
                currwinmax=curr;
            currwinmaxidx=r;
            }
            r++;
            if(r-l==k){
                res.push_back(currwinmax);
                if(l==currwinmaxidx){
                    currwinmax=INT_MIN;
                    currwinmaxidx=-1;
                    for(int i=l+1;i<r;i++){
                        if(nums[i]>=currwinmax){
                            currwinmax=nums[i];
                            currwinmaxidx=i;
                        }
                    }
                }
                l+=1;
            }

        }
        return res;
    }
};
