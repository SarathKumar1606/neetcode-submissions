class Solution {
    public double myPow(double x, int n) {
        if(x==0) return 0.0;
        if(n==0) return 1.0;
        if(n==1) return x;
       
       if(n<0){
        if(n==Integer.MIN_VALUE){
            return 1/x*myPow(x,Integer.MAX_VALUE);
        }
        return 1/myPow(x,-n);
       }
        double half=myPow(x,n/2);
        if(n%2==0) return half*half;
        else return half*half*x;
    }
}
