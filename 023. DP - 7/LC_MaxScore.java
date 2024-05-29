import java.util.HashMap;
import java.util.Map;

public class LC_MaxScore {
    public int recursionHelper(int[] cardPoints, int l, int h, int k) {
        if (k == 0) return 0;

        int lPick = cardPoints[l] + recursionHelper(cardPoints, l + 1, h, k - 1);
        int rPick = cardPoints[h] + recursionHelper(cardPoints, l, h - 1, k - 1);
        return Math.max(lPick, rPick);
    }
    public int recursionApproach(int[] cardPoints, int k){
        if (k >= cardPoints.length) {
            int sum = 0;
            for (int e : cardPoints) sum += e;
            return sum;
        } else {
            return recursionHelper(cardPoints, 0, cardPoints.length - 1, k);
        }
    }

    Map<String, Integer> memo;
    public int memoHelper(int[] cardPoints, int l, int h, int k) {
        if (k == 0) return 0;
        String key = l + "," + h + "," + k;
        if (memo.containsKey(key)) return memo.get(key);

        int leftPick = cardPoints[l] + memoHelper(cardPoints, l + 1, h, k - 1);
        int rightPick = cardPoints[h] + memoHelper(cardPoints, l, h - 1, k - 1);
        int result = Math.max(leftPick, rightPick);
        memo.put(key, result);
        return result;
    }

    public int memoApproach(int[] cardPoints, int k) {
        if (k >= cardPoints.length) {
            int sum = 0;
            for (int e : cardPoints) sum += e;
            return sum;
        } else {
            memo = new HashMap<>();
            return memoHelper(cardPoints, 0, cardPoints.length - 1, k);
        }
    }

    public int slidingWindowApproach(int[] cardPoints, int k){
        int sum_left = 0;
        for (int i = 0; i < k; i++) {
            sum_left += cardPoints[i];
        }
        int sum_right = 0;
        int res = sum_left;
        for (int i = 0; i < k; i++) {
            sum_left -= cardPoints[k - 1 - i];
            sum_right += cardPoints[cardPoints.length - 1 - i];
            res = Math.max(res, sum_left + sum_right);
        }
        return res;
    }

    public int maxScore(int[] cardPoints, int k) {
        return slidingWindowApproach(cardPoints, k);

    }
}
