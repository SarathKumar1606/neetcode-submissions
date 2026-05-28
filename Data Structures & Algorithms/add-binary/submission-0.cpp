class Solution {
public:
    string addBinary(string a, string b) {
        char carry='0';
        int n=max(a.size(),b.size());
        while(a.size()<n) a="0"+a;
        while(b.size()<n) b="0"+b;
        string res="";
        for(int i=n-1; i>=0;i--){
            char x=a[i],y=b[i];
            char curr;
           if(carry=='0'){
            if((x=='1' && y=='0')||(x=='0' && y=='1')){
                    res+='1';
                    carry='0';
            }else if(x=='1'&& y=='1'){
                carry='1';
                res+='0';
            }else{
                res+='0';
                carry='0';
            }
           }else{
            if((x=='1' && y=='0')||(x=='0' && y=='1')){
                    res+='0';
                    carry='1';
            }else if(x=='1'&& y=='1'){
                carry='1';
                res+='1';
            }else{
                res+='1';
                carry='0';
            }
           }

        }
        if(carry=='1') res+='1';
     reverse(res.begin(),res.end());
     return res;

        
    }
};