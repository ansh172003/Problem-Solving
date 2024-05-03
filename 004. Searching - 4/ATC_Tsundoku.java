import java.util.Scanner;

public class ATC_Tsundoku {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long m = scanner.nextLong();
        long k = scanner.nextLong();
        long[] a = new long[1 + (int) n];
        long[] b = new long[1 + (int) m];
        a[0] = 0;
        b[0] = 0;
        for (long i = 1; i <= n; i++) {
            long x = scanner.nextLong();
            a[(int) i] = x + a[(int) (i - 1)];
        }
        for (long i = 1; i <= m; i++) {
            long x = scanner.nextLong();
            b[(int) i] = x + b[(int) (i - 1)];
        }
        long ans = 0;
        for (long i = 0; i <= n; i++) {
            for (long j = m; j >= 0; j--) {
                if (a[(int) i] + b[(int) j] <= k) {
                    ans = i + j;
                    break;
                }
            }
        }

        System.out.println(ans);
    }
}
