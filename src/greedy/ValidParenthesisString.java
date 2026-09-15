package greedy;

public class ValidParenthesisString {
    public boolean checkValidString(String s) {
        // ArrayDeque<Integer> open = new ArrayDeque<>();
        // ArrayDeque<Integer> star = new ArrayDeque<>();

        // for(int i=0; i<s.length(); i++) {
        // char c = s.charAt(i);
        // if(c == '(') {
        // open.push(i);
        // } else if(c == '*') {
        // star.push(i);
        // } else {
        // if(!open.isEmpty()) {
        // open.pop();
        // } else if(!star.isEmpty()) {
        // star.pop();
        // } else {
        // return false;
        // }
        // }
        // }

        // while(!open.isEmpty() && !star.isEmpty()) {
        // int starIdx = star.pop();
        // int openIdx = open.pop();
        // if(starIdx < openIdx) return false;
        // }

        // return open.isEmpty();

        int minOpen = 0;
        int maxOpen = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                minOpen++;
                maxOpen++;
            } else if (c == ')') {
                minOpen--;
                maxOpen--;
            } else {
                minOpen--;
                maxOpen++;
            }

            if (maxOpen < 0)
                return false;

            minOpen = Math.max(minOpen, 0);
        }

        return minOpen == 0;
    }
}
