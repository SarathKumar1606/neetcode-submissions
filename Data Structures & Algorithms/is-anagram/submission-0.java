class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> mp1= new HashMap<>();
        for(int i=0; i<s.length(); i++){
            char c=s.charAt(i);
            if(mp1.containsKey(c)){
                mp1.put(c,mp1.get(c)+1);
            }else{
                mp1.put(c,1);
            }
        }
       HashMap<Character, Integer> mp2= new HashMap<>();
        for(int i=0; i<t.length(); i++){
            char c=t.charAt(i);
            if(mp2.containsKey(c)){
                mp2.put(c,mp2.get(c)+1);
            }else{
                mp2.put(c,1);
            }
        }
        if(mp1.size()!=mp2.size()) return false;
        for(Map.Entry<Character,Integer> entry : mp1.entrySet()){
            char c1=entry.getKey();
            int f1=entry.getValue();
            int f2=mp2.getOrDefault(c1,0);
            if(f1!=f2) return false;
        }
        return true;

    }
}
