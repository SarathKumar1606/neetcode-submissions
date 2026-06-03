class Solution {

    Map<Character, String> mp = new HashMap<>();

    private void backtrack(String digits, int pos,
                           StringBuilder temp,
                           List<String> res) {

        if (pos == digits.length()) {
            res.add(temp.toString());
            return;
        }

        String letters = mp.get(digits.charAt(pos));

        for (int i = 0; i < letters.length(); i++) {

            temp.append(letters.charAt(i));

            backtrack(digits, pos + 1, temp, res);

            temp.deleteCharAt(temp.length() - 1);
        }
    }

    public List<String> letterCombinations(String digits) {

        List<String> res = new ArrayList<>();

        if (digits.length() == 0)
            return res;

        mp.put('2', "abc");
        mp.put('3', "def");
        mp.put('4', "ghi");
        mp.put('5', "jkl");
        mp.put('6', "mno");
        mp.put('7', "pqrs");
        mp.put('8', "tuv");
        mp.put('9', "wxyz");

        backtrack(digits, 0, new StringBuilder(), res);

        return res;
    }
}