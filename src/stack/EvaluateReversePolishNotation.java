package stack;

public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        // ArrayDeque<Integer> stack = new ArrayDeque<>();

        // for(String s : tokens) {
        // if(s.equals("+") || s.equals("-") || s.equals("/") || s.equals("*")) {
        // int base = stack.pop();
        // int top = stack.pop();
        // if(s.equals("+")) {
        // stack.push(top + base);
        // } else if(s.equals("-")) {
        // stack.push(top - base);
        // } else if(s.equals("/")) {
        // stack.push(top/base);
        // } else {
        // stack.push(top * base);
        // }
        // } else {
        // stack.push(Integer.parseInt(s));
        // }
        // }

        // return stack.pop();

        int[] stack = new int[tokens.length];
        int idx = 0;

        for (String s : tokens) {
            char c = s.charAt(0);
            if (s.length() == 1) {
                switch (c) {
                    case '+':
                        stack[idx - 2] = stack[idx - 2] + stack[idx - 1];
                        idx--;
                        continue;
                    case '-':
                        stack[idx - 2] = stack[idx - 2] - stack[idx - 1];
                        idx--;
                        continue;
                    case '*':
                        stack[idx - 2] = stack[idx - 2] * stack[idx - 1];
                        idx--;
                        continue;
                    case '/':
                        stack[idx - 2] = stack[idx - 2] / stack[idx - 1];
                        idx--;
                        continue;
                }

            }

            stack[idx++] = Integer.parseInt(s);
        }

        return stack[0];
    }
}
