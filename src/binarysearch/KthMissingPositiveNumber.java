package binarysearch;

public class KthMissingPositiveNumber {
    public int findKthPositive(int[] arr, int k) {
        // int maxi = 0;
        // for(int x : arr) {
        // maxi = Math.max(maxi, x);
        // }
        // int count = 0;
        // Set<Integer> set = Arrays.stream(arr)
        // .boxed()
        // .collect(Collectors.toSet());
        // for(int i=1; i<=maxi+k; i++) {
        // if(!set.contains(i)) {
        // count++;
        // if(count == k) return i;
        // }
        // }

        // return maxi+k;
        int l = 0, r = arr.length - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            int missing = arr[mid] - mid - 1;

            if (missing < k) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return l + k;

    }
}
