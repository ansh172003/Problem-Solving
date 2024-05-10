public class LC_DecodeWays {
    public int dpApproach(String s){
        if (s.charAt(0) == '0') return 0;
        int n = s.length();
        int[] cache = new int[n + 1];
        cache[0] = 1;
        cache[1] = 1;
        for (int i = 2; i <= n; i++) {
            int one = Character.getNumericValue(s.charAt(i - 1));
            int two = Integer.parseInt(s.substring(i - 2, i));
            if (1 <= one && one <= 9) {
                cache[i] += cache[i - 1];
            }
            if (10 <= two && two <= 26) {
                cache[i] += cache[i - 2];
            }
        }
        return cache[n];
    }
    public int spaceOptimized(String s){
        int n = s.length();
        int p2 = 1;
        int p1 = s.charAt(n-1) == '0' ? 0 : 1;

        for(int i = n - 2; i >= 0; i--){
            if(s.charAt(i) == '0'){
                p2 = p1;
                p1 = 0;
                continue;
            }
            int curr = p1;
            if (i + 1 < n) {
                int firstDigit = Integer.parseInt(s.charAt(i) + "");
                int secondDigit = Integer.parseInt(s.charAt(i + 1) + "");
                int combinedNumber = firstDigit * 10 + secondDigit;
                if (combinedNumber <= 26) {
                    curr += p2;
                }
            }

            p2 = p1;
            p1 = curr;
        }
        return p1;
    }
    public int numDecodings(String s) {
        return dpApproach(s);
    }
}
