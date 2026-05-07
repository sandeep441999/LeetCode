package arrays;

public class TrappingRainWater {
    public int trap(int[] height) {
        if (height.length == 0)
            return 0;
        int l = 0, r = height.length - 1;
        int res = 0;
        int lmax = 0, rmax = 0;
        while (l < r) {
            if (height[l] < height[r]) {
                if (height[l] >= lmax) {
                    lmax = height[l];
                } else {
                    res += lmax - height[l];
                }
                l += 1;
            } else {
                if (height[r] >= rmax) {
                    rmax = height[r];
                } else {
                    res += rmax - height[r];
                }
                r -= 1;
            }
        }
        // int lmax=height[l], rmax=height[r];

        // while(l<r) {
        // if(lmax<rmax) {
        // l+=1;
        // lmax = Math.max(lmax, height[l]);
        // res+=lmax - height[l];
        // } else {
        // r-=1;
        // rmax = Math.max(rmax, height[r]);
        // res+=rmax-height[r];
        // }
        // }

        return res;
    }
}
