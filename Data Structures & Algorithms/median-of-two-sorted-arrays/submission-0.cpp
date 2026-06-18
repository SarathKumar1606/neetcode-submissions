class Solution {
public:
    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
        if(nums1.size()>nums2.size()){
            swap(nums1,nums2);
        }
        int n=nums1.size();
        int m=nums2.size();
        int total=n+m;
        int leftSize=(total+1)>>1;

        auto is_before=[&](int partA){
            int partB=leftSize-partA;

            int aLeft=(partA==0)?INT_MIN:nums1[partA-1];
            int aRight=(partA==n)?INT_MAX:nums1[partA];
            int bLeft=(partB==0)?INT_MIN:nums2[partB-1];
            int bRight=(partB==m)?INT_MAX:nums2[partB];
            return (aRight<bLeft);
        };
        int l=-1,r=n+1;
        while((r-l)>1){
            int mid=(l+r)>>1;
            if(is_before(mid)){
                l=mid;
            }else{
                r=mid;
            }
        }
        int partA=r;
        int partB=leftSize-partA;

        int aLeft=(partA==0)?INT_MIN:nums1[partA-1];
        int aRight=(partA==n)?INT_MAX:nums1[partA];
        int bLeft=(partB==0)?INT_MIN:nums2[partB-1];
        int bRight=(partB==m)?INT_MAX:nums2[partB];

        int leftMax=max(aLeft,bLeft);
        int rightMin=min(aRight,bRight);
        if(total%2){
            return leftMax;
        }
        return (leftMax+rightMin)/2.0;
    }
};