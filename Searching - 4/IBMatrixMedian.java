import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class IBMatrixMedian {
    // Approach 1 - Make arbitrary array and then sort it
    public int findMedianBruteForce(ArrayList<ArrayList<Integer>> A) {
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < A.size(); i++) {
            for (int j = 0; j < A.get(0).size(); j++) {
                list.add(A.get(i).get(j));
            }
        }
        Collections.sort(list);
        int mid = list.size() / 2;
        int median;
        if (list.size() % 2 == 0) {
            median = (list.get(mid - 1) + list.get(mid)) / 2;
        } else {
            median = list.get(mid);
        }

        return median;
    }
    // Approach 2 - Using binary Search
    public static int countSmallerThanMid(ArrayList<Integer> A, int mid, int n) {
        int l = 0, h = n - 1;
        while (l <= h) {
            int md = (l + h) >> 1;
            if (A.get(md) <= mid) {
                l = md + 1;
            } else {
                h = md - 1;
            }
        }
        return l;
    }

    public int findMedianBinarySearch(ArrayList<ArrayList<Integer>> A) {
        int low = 1;
        int high = Integer.MAX_VALUE;
        int row = A.size();
        int col = A.get(0).size();
        while (low <= high) {
            int mid = (low + high) / 2;
            int cnt = 0;
            for (int i = 0; i < row; i++) {
                cnt += countSmallerThanMid(A.get(i), mid, col);
            }
            if (cnt <= (row * col) / 2)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return low;
    }
}
