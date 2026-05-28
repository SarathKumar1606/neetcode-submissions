class Solution {
public:
    int maxArea(vector<int>& heights) {
        int l=0, r=heights.size()-1;
        vector<int> waterval;
        while(l<r){
            int val=(r-l)*min(heights[l],heights[r]);
            waterval.push_back(val);
            if(heights[l]<heights[r]){
                l++;
            }else if(heights[l]>heights[r]){
                r--;
            }else{
                l++;
                r--;
            }

        }
        return *max_element(waterval.begin(),waterval.end());
        
    }
};
