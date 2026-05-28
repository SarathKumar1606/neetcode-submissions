class Solution {
public:
    int trap(vector<int>& height) {

        int n=height.size();
        int currPreMax=INT_MIN;
        vector<int> prefixMax(n),suffixMax(n);
        for(int i=0; i<n;i++){
            if(height[i]>currPreMax){
                currPreMax=height[i];
            }
            prefixMax[i]=currPreMax;
        }
        int currSufMax=INT_MIN;
        for(int i=n-1; i>=0;i--){
            if(height[i]>currSufMax){
                currSufMax=height[i];
            }
            suffixMax[i]=currSufMax;
        }

        int ans=0;

        int l=0, r=n-1;
        for(int i=0; i<n; i++){
            ans+=min(prefixMax[i],suffixMax[i])-height[i];
        }
        return ans;
        
    }
};
