package binarysearch;

public class UglyNumberIII {
    public int nthUglyNumber(int n, int a, int b, int c) {
        long l = Math.min(a, Math.min(b, c)), r = Math.max(a, Math.max(b, c)) * (long) n;
        long ans = 0;
        long ab = lcm(a, b);
        long bc = lcm(b, c);
        long ca = lcm(c, a);
        long abc = lcm(ab, c);

        while (l <= r) {
            long mid = l + (r - l) / 2;

            if (divisibleCount(n, a, b, c, mid, ab, bc, ca, abc) >= n) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return (int) ans;
    }

    public long gcd(long a, long b) {
        while (b != 0) {
            long temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    public long lcm(long a, long b) {
        return (long) ((a * b) / gcd(a, b));
    }

    public long divisibleCount(int n, int a, int b, int c, long mid, long ab, long bc, long ca, long abc) {
        return (mid / a) + (mid / b) + (mid / c) - mid / ab - mid / bc - mid / ca + mid / abc;
    }
}
