package slidingwindow;

public class ShiftingLettersII {
    public String shiftingLetters(String s, int[][] shifts) {
        int n = s.length();
        int[] diff = new int[n + 1];
        for (int[] x : shifts) {
            int l = x[0], r = x[1];
            int change = x[2] == 1 ? 1 : -1;
            diff[l] += change;
            diff[r + 1] -= change;
        }
        char[] chars = s.toCharArray();
        int shift = 0;

        for (int i = 0; i < n; i++) {
            shift += diff[i];

            int newChar = (chars[i] - 'a' + shift) % 26;

            if (newChar < 0) {
                newChar += 26;
            }

            chars[i] = (char) ('a' + newChar);

        }

        return new String(chars);

        // char[] chars = s.toCharArray();
        // for(int[] x : shifts) {
        // int l = x[0], r=x[1];
        // if(x[2] == 0) {
        // while(l<=r) {
        // int newChar = chars[l] - 1;
        // if(newChar <= 96) {
        // chars[l] = 'z';
        // } else {
        // chars[l] = (char) newChar;
        // }
        // l++;
        // }
        // } else {
        // while(l<=r) {
        // int newChar = chars[l] + 1;
        // if(newChar >= 123) {
        // chars[l] = 'a';
        // } else {
        // chars[l] = (char) newChar;
        // }
        // l++;
        // }
        // }
        // }
        // return new String(chars);
    }
}
