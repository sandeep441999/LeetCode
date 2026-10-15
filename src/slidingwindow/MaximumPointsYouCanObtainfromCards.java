package slidingwindow;

public class MaximumPointsYouCanObtainfromCards {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int l = 0, r = 0;
        int sum = 0;
        int size = n - k;
        int total = 0;
        for (int x : cardPoints) {
            total += x;
        }

        int minsum = Integer.MAX_VALUE;

        while (r < n) {
            sum += cardPoints[r];

            while (r - l + 1 > size) {
                sum -= cardPoints[l];
                l++;
            }

            if (r - l + 1 == size) {
                minsum = Math.min(sum, minsum);
            }
            r++;
        }

        return total - minsum;
    }
}
