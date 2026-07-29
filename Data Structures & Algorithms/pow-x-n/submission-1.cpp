class Solution {
public:
    double myPow(double x, int n) {
        if(x==0) return 0.0;
        if(n==0) return 1.0;
        if(n==1) return x;
       
       double a=1.0;
       long long exp=abs((long long)n);
       while(exp>0){
        if(exp%2==1){
            a=a*x;
        }
        x=x*x;
        exp/=2;
       }
       return n>0? a : 1/a;
    }
};
