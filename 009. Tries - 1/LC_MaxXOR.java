import java.util.*;

public class LC_MaxXOR {
    public int findMaximumXOR(int[] nums) {
        int res = 0;
        int max = Arrays.stream(nums).max().getAsInt();
        if (max == 0) return 0;
        int mBit = (int) (Math.log(max) / Math.log(2));
        int mask = 0;
        for (int i = mBit; i >= 0; --i) {
            mask |= 1 << i;
            Set<Integer> preSet = new HashSet<>();
            for (final int num : nums)
                preSet.add(num & mask);
            final int candidate = res | 1 << i;
            for (final int prefix : preSet)
                if (preSet.contains(prefix ^ candidate)) {
                    res = candidate;
                    break;
                }
        }
        return res;
    }
}
