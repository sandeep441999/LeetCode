package backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LetterCombinationsofaPhoneNumber {
    HashMap<Character, List<String>> map;
    List<String> res;

    public List<String> letterCombinations(String digits) {
        map = new HashMap<>();
        map.put('2', List.of("a", "b", "c"));
        map.put('3', List.of("d", "e", "f"));
        map.put('4', List.of("g", "h", "i"));
        map.put('5', List.of("j", "k", "l"));
        map.put('6', List.of("m", "n", "o"));
        map.put('7', List.of("p", "q", "r", "s"));
        map.put('8', List.of("t", "u", "v"));
        map.put('9', List.of("w", "x", "y", "z"));
        res = new ArrayList<>();
        dfs(digits, 0, "");
        return res;
    }

    public void dfs(String digits, int idx, String cur) {
        if (idx == digits.length()) {
            res.add(cur);
            return;
        }

        for (String c : map.get(digits.charAt(idx))) {
            dfs(digits, idx + 1, cur + c);
        }
    }
}
