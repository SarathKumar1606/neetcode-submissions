class Solution {
    HashMap<String,List<String>> mp;
    private void backtrack(String digits,int pos,StringBuilder temp, List<String> res){
        if(temp.length()==digits.length()){
            res.add(temp.toString());
            return;
        }
        if(pos==digits.length()) return;
        String dig="";
        dig+=digits.charAt(pos);
        
        for(String c : mp.get(dig)){
            temp.append(c);
            backtrack(digits,pos+1,temp,res);
            temp.deleteCharAt(temp.length()-1);
        }
        


    }
    public List<String> letterCombinations(String digits) {
        List<String> res= new ArrayList<>();
        if(digits.equals("")) return res;
         mp= new HashMap<>();
        mp.put("2",Arrays.asList("a","b","c"));
        mp.put("3", Arrays.asList("d", "e", "f"));
        mp.put("4", Arrays.asList("g", "h", "i"));
        mp.put("5", Arrays.asList("j", "k", "l"));
        mp.put("6", Arrays.asList("m", "n", "o"));
        mp.put("7", Arrays.asList("p", "q", "r" ,"s"));
        mp.put("8", Arrays.asList("t", "u", "v"));
        mp.put("9", Arrays.asList("w", "x", "y" ,"z"));
       
      
            backtrack(digits,0,new StringBuilder(),res);
        
        return res;
        
    }
}
