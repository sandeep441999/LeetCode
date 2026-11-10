package binarysearch;

public class MedianofTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // int n1 = nums1.length, n2 = nums2.length;

        // if(n1>n2) return findMedianSortedArrays(nums2, nums1);
        // int n = n1+n2;

        // int half = (n1+n2 + 1) / 2;
        // int low = 0, high = n1;

        // while(low<=high) {
        // int mid1 = (low+high) >> 1;
        // int mid2 = half - mid1;

        // int l1 = Integer.MIN_VALUE, l2 = Integer.MIN_VALUE, r1 = Integer.MAX_VALUE,
        // r2 = Integer.MAX_VALUE;

        // if(mid1<n1) {
        // r1 = nums1[mid1];
        // }
        // if(mid2<n2) {
        // r2 = nums2[mid2];
        // }
        // if(mid1-1>=0) {
        // l1 = nums1[mid1-1];
        // }
        // if(mid2-1>=0) {
        // l2 = nums2[mid2-1];
        // }

        // if(l1<=r2 && l2<=r1) {
        // if(n%2==1) return Math.max(l1, l2);
        // else return ((double) (Math.max(l1, l2) + Math.min(r1, r2))) / 2.0;
        // } else if(l1>r2) {
        // high = mid1-1;
        // } else {
        // low = mid1+1;
        // }

        // }

        // return 0;

        // int n1 = nums1.length;
        // int n2 = nums2.length;
        // int l1=0, l2=0, m1=0, m2=0, idx=0;

        // while(idx<((n1+n2)/2+1)) {
        // m2=m1;
        // if(l1<n1 && l2<n2) {
        // if(nums1[l1]<nums2[l2]) {
        // m1=nums1[l1++];
        // } else {
        // m1=nums2[l2++];
        // }
        // } else if(l1<n1) {
        // m1=nums1[l1++];
        // } else {
        // m1=nums2[l2++];
        // }
        // idx++;
        // }

        // if((n1+n2) %2==0) return (double) (m1+m2)/2.0;
        // else return (double) m1;

        // PriorityQueue<Integer> min = new PriorityQueue<>();
        // PriorityQueue<Integer> max = new PriorityQueue<>((a, b) -> Integer.compare(b,
        // a));

        // int len = Math.min(nums1.length, nums2.length);
        // int l=0, r=0;

        // while(l<nums1.length && r < nums2.length) {
        // int n1 = nums1[l], n2 = nums2[r];

        // if(n1<=n2) {
        // min.offer(n1);
        // l++;
        // } else {
        // min.offer(n2);
        // r++;
        // }
        // if(min.size() > max.size()) {
        // max.offer(min.poll());
        // }
        // }

        // while(l<nums1.length) {
        // min.offer(nums1[l]);
        // l++;
        // if(min.size() > max.size()) {
        // max.offer(min.poll());
        // }
        // }

        // while(r<nums2.length) {
        // min.offer(nums2[r]);
        // r++;
        // if(min.size() > max.size()) {
        // max.offer(min.poll());
        // }
        // }

        // int n = nums1.length+nums2.length;

        // if(n%2 == 0) return (double) (min.peek() + max.peek())/2.0;
        // return (double) max.peek();

        int n1 = nums1.length, n2 = nums2.length;
        if (n1 > n2)
            return findMedianSortedArrays(nums2, nums1);

        int half = (n1 + n2 + 1) / 2;

        int l = 0, r = n1;

        while (l <= r) {
            int mid1 = (l + r) >> 1;

            int mid2 = half - mid1;
            int l1 = Integer.MIN_VALUE, l2 = Integer.MIN_VALUE, r1 = Integer.MAX_VALUE, r2 = Integer.MAX_VALUE;

            if (mid1 - 1 >= 0)
                l1 = nums1[mid1 - 1];
            if (mid1 < n1)
                r1 = nums1[mid1];
            if (mid2 - 1 >= 0)
                l2 = nums2[mid2 - 1];
            if (mid2 < n2)
                r2 = nums2[mid2];

            if (l1 <= r2 && l2 <= r1) {
                if ((n1 + n2) % 2 == 0)
                    return (double) (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
                else
                    return (double) Math.max(l1, l2);
            }
            if (l1 > r2)
                r = mid1 - 1;
            if (l2 > r1)
                l = mid1 + 1;
        }

        return 0.0;
    }
}
