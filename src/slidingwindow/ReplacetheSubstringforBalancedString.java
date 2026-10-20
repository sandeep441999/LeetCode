package slidingwindow;

public class ReplacetheSubstringforBalancedString {
    public int balancedString(String s) {
        int k = s.length() / 4;
        int[] count = new int[128];
        int[] extra = new int[128];
        for (char c : s.toCharArray()) {
            count[c]++;
        }

        for (char c : s.toCharArray()) {
            extra[c] = Math.max(0, count[c] - k);
        }

        if (extra['Q'] == 0 && extra['W'] == 0 &&
                extra['E'] == 0 && extra['R'] == 0) {
            return 0;
        }

        int[] window = new int[128];

        int l = 0, r = 0, n = s.length();
        int ans = n;

        while (r < n) {
            window[s.charAt(r)]++;
            while (extra['Q'] <= window['Q'] &&
                    extra['W'] <= window['W'] &&
                    extra['R'] <= window['R'] &&
                    extra['E'] <= window['E']) {
                ans = Math.min(ans, r - l + 1);
                window[s.charAt(l)]--;
                l++;
            }
            r++;
        }
        return ans;
    }
}
