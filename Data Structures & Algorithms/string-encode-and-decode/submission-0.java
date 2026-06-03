class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb=new StringBuilder();
        for(String s : strs){
            int n=s.length();
            sb.append(n);
            sb.append("#");
            sb.append(s);
        }
        return sb.toString();


    }

    public List<String> decode(String str) {
        List<String> ans= new ArrayList<>();
        StringBuilder sb= new StringBuilder();
        for(int i=0; i<str.length();i++){
            if(sb.length()==0){
                int n=str.charAt(i)-'0';
                int start=i+2; 
                while(start<i+n+2 && start<str.length()){
                        sb.append(str.charAt(start));
                        start++;
                }
                
                ans.add(sb.toString());
                sb.setLength(0);
                i=start-1;

            }

        }
        return ans;

    }
}
