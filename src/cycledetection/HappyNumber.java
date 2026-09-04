package cycledetection;

public class HappyNumber {
    public boolean isHappy(int n) {
        // Set<Integer> set = new HashSet<>();

        // while(n!=1) {
        // if(set.contains(n)) return false;
        // set.add(n);

        // int sum = 0;

        // while(n>0) {
        // int digit = n %10;
        // sum += digit*digit;
        // n = n/10;
        // }
        // n = sum;
        // }

        // return true;

        int slow = n, fast = n;

        while (fast != 1) {
            slow = loop(slow);
            fast = loop(loop(fast));

            if (slow == fast && fast != 1)
                return false;
        }

        return true;
    }

    public int loop(int n) {
        int sum = 0;

        while (n > 0) {
            int d = n % 10;
            sum += d * d;
            n = n / 10;
        }
        return sum;
    }
}
