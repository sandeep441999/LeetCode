package backtracking;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class GenerateParentheses {
    List<String> res;

    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>();
        dfs(n, new StringBuilder(), 0, 0);
        return res;
    }

    public void dfs(int n, StringBuilder cur, int open, int close) {
        // if(2*n == cur.length()) {
        // if(isValid(cur)) {
        // res.add(cur);
        // return;
        // }
        // }
        if (2 * n == cur.length()) {
            res.add(cur.toString());
            return;
        }

        // for(String c : List.of("(", ")")) {
        // if((c == "(" && open + 1 <=n)) {
        // cur+=c;
        // dfs(n, cur, open+1, close);
        // cur = cur.substring(0, cur.length()-1);
        // } else if((c== ")" && close+1 <= n)) {
        // cur+=c;
        // dfs(n, cur, open, close+1);
        // cur = cur.substring(0, cur.length()-1);
        // } else {
        // continue;
        // }
        // }

        if (open < n) {
            cur.append('(');
            dfs(n, cur, open + 1, close);
            cur.deleteCharAt(cur.length() - 1);
        }
        if (close < open) {
            cur.append(')');
            dfs(n, cur, open, close + 1);
            cur.deleteCharAt(cur.length() - 1);
        }
    }

    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else {
                if (stack.isEmpty())
                    return false;
                char cur = stack.pop();
                if (cur != '(')
                    return false;
            }
        }
        return stack.isEmpty();
    }
}
