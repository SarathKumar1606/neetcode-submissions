class Solution {
public:
    int getSum(int a, int b) {
        while(b!=0){
            int currsum=a^b;
            int carry=(a&b)<<1;
            a=currsum;
            b=carry;
        }
        return a;
        
    }
};
