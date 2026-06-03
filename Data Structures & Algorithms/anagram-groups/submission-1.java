class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<Integer>> mp= new HashMap<>();
        for(int i=0; i<strs.length; i++){
            String s=strs[i];
            int[] temp = new int[26];
            for(char c : s.toCharArray()){
                    temp[c-'a']++;
            }
            StringBuilder sb= new StringBuilder();
            for(int j : temp){
                sb.append(j+'a').append("#");
            }
            String key=sb.toString();
            if(mp.containsKey(key)){
                mp.get(key).add(i);
            }else{
                mp.put(key,new ArrayList<>());
                mp.get(key).add(i);
            }
        }
        List<List<String>> res = new ArrayList<>();
        for(List<Integer> cand: mp.values()){
           
            List<String> temp= new ArrayList<>();
            for(int i : cand){
                temp.add(strs[i]);
            }
            res.add(temp);
        }
        return res;
        
    }
}
