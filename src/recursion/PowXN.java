package recursion;

public class PowXN {
    public double myPow(double x, int n) {
        double ans = rec(x, Math.abs(n));
        return n > 0 ? ans : 1 / ans;
    }

    public double rec(double x, int n) {
        if (x == 0)
            return 0;
        if (n == 0)
            return 1;

        double res = rec(x * x, n / 2);

        return n % 2 == 0 ? res : res * x;
    }
}
