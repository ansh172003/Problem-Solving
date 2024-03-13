public class SelfSumOfAllSubArrays {
    public static int findMaxSubArraySum(int[] arr, int n, int sum) {
        int curr_sum = arr[0], max_sum = 0, start = 0;

        for (int i = 1; i < n; i++) {

            if (curr_sum <= sum)
                max_sum = Math.max(max_sum, curr_sum);
            while (curr_sum + arr[i] > sum && start < i) {
                curr_sum -= arr[start];
                start++;
            }
            curr_sum += arr[i];
        }
        if (curr_sum <= sum)
            max_sum = Math.max(max_sum, curr_sum);

        return max_sum;
    }

    public static void main(String[] args) {
        int[] arr = { 6, 8, 9};
        int n = arr.length;
        int sum = 20;
        System.out.println(findMaxSubArraySum(arr, n, sum));
    }

}
