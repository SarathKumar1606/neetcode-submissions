class Solution {
    private void backtrack(String digits,int pos,String temp, List<String> res){
        if(temp.length()=digits.length()){
            res.add(temp);
            return;
        }
        if(pos==digits.length) return;
        int dig=digits[pos]-'0';

    }
    public List<String> letterCombinations(String digits) {
        List<String> res= new ArrayList<>();
        HashMap<Character,List<Characters>> mp= new HashMap<>();
        mp.put("2",Arrays.asList("a","b","c"));
        mp.put("3", Arrays.asList("d", "e", "f"));
        mp.put("3", Arrays.asList("d", "e", "f"));
        mp.put("3", Arrays.asList("d", "e", "f"));
        backtrack();
        return res;
        
    }
}
