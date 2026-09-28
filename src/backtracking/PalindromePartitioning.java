package backtracking;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> path = new ArrayList<>();
        f(0, s, path, res);
        return res;
    }

    public void f(int idx, String s, List<String> path, List<List<String>> res) {
        if (idx == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = idx; i < s.length(); i++) {
            if (isPalindrome(idx, i, s)) {
                path.add(s.substring(idx, i + 1));
                f(i + 1, s, path, res);
                path.remove(path.size() - 1);
            }
        }
    }

    public boolean isPalindrome(int start, int end, String s) {
        while (start <= end) {
            if (s.charAt(start++) != s.charAt(end--))
                return false;
        }

        return true;
    }
}
