package strings;

public class ProcessStringwithSpecialOperationsII {
    public char processStr(String s, long k) {

        // StringBuilder sb = new StringBuilder();

        // for(char c : s.toCharArray()) {
        // if(c == '*') {
        // if(sb.length() > 0) {
        // sb.deleteCharAt(sb.length()-1);
        // }
        // } else if(c == '#') {
        // if(sb.length() > 0) {
        // sb.append(sb.toString());
        // }

        // } else if(c == '%') {
        // sb = sb.reverse();
        // } else {
        // sb.append(c);
        // }
        // }

        // return k<=sb.length()-1 ? sb.charAt((int) k) : '.';

        // StringBuilder never works and as it gets the MLE
        long l = 0;

        for (char c : s.toCharArray()) {
            if (c == '*') {
                l = Math.max(0, l - 1);
            } else if (c == '#') {
                l *= 2;
            } else if (c == '%') {
                continue;
            } else {
                l++;
            }
        }

        if (k >= l)
            return '.';

        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == '*') {
                l++;
            } else if (c == '#') {
                long half = l / 2;
                if (k >= half)
                    k -= half;
                l = half;
            } else if (c == '%') {
                k = l - 1 - k;
            } else {
                if (k == l - 1)
                    return c;
                l--;
            }
        }

        return '.';
    }
}
