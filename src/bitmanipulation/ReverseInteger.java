package bitmanipulation;

public class ReverseInteger {
    public int reverse(int x) {
        if (x == 0)
            return 0;
        int res = 0;
        while (x != 0) {
            int rem = x % 10;
            x = x / 10;
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && rem > 7))
                return 0;
            if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && rem < -8))
                return 0;
            res = res * 10 + rem;

        }

        return res;

    }
}
