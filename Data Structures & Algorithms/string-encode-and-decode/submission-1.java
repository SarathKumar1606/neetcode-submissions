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
            int j=i;
            while(str.charAt(j)!='#'){
                j++;
            }
                int n=Integer.parseInt(str.substring(i,j));
                int start=j+1; 
                while(start<(j+1)+n && start<str.length()){
                        sb.append(str.charAt(start));
                        start++;
                }
                
                ans.add(sb.toString());
                sb.setLength(0);
                i=start-1;

            

        }
        return ans;

    }
}
