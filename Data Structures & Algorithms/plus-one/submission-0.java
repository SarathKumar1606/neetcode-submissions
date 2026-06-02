class Solution {
    public int[] plusOne(int[] digits) {
        int n=digits.length;
        int carry=1;
        int i=n-1;
        while(i>=0 && carry==1){
            digits[i]+=carry;
            if(digits[i]<10){
                carry=0;
                break;
            }else{
                digits[i]=0;
                carry=1;
            }
            i--;
        }
        if(carry==1){
            int[] newarr=new int[n+1];
            newarr[0]=1;
            for(int j=1; j<n+1;j++){
                newarr[j]=digits[j-1];
            }
            return newarr;
        }
        return digits;

        
    }
}
