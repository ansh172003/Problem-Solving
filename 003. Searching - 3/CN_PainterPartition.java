import java.util.ArrayList;

public class CN_PainterPartition {
    public static boolean distancePossibe(ArrayList<Integer> boards, int givenLength, int k) {
        int lengthperPainter = 0;
        int painter = 1;
        for (int i = 0; i < boards.size(); i++) {
            if (lengthperPainter + boards.get(i) <= givenLength) {
                lengthperPainter += boards.get(i);
            } else {
                painter++;
                lengthperPainter = boards.get(i);
            }
        }
        return (painter <= k);
    }

    public static int findLargestMinDistance(ArrayList<Integer> boards, int k) {
        int maxi = Integer.MIN_VALUE;
        int sumLength = 0;
        int n = boards.size();
        for (int i = 0; i < n; i++) {
            maxi = Math.max(maxi, boards.get(i));
            sumLength += boards.get(i);
        }
        int low = maxi;
        int high = sumLength;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (distancePossibe(boards, mid, k)) {
                high = mid - 1;
            } else low = mid + 1;
        }
        return low;
    }
}