import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HE_SubArraysXOR {
    static int subArrayXor(int arr[], int n, int k){
        int res = 0;
        int[] arrXOR = new int[n];
        HashMap<Integer, Integer> map = new HashMap<>();
        arrXOR[0] = arr[0];
        for (int i = 1; i < n; i++)
            arrXOR[i] = arrXOR[i - 1] ^ arr[i];
        for (int i = 0; i < n; i++) {
            int xorSoFar = arrXOR[i];
            int remainingXor = k ^ xorSoFar;
            if (map.containsKey(remainingXor))
                res += map.get(remainingXor);
            if (xorSoFar < k)
                res++;
            map.put(xorSoFar, map.getOrDefault(xorSoFar, 0) + 1);
        }
        return res;

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCasesCount = sc.nextInt();
        int finalRes = 0;
        for(int test = 0; test < testCasesCount; test++){
            int arrayLen = sc.nextInt();
            int k = sc.nextInt();
            int[] arr = new int[arrayLen];
            for(int i = 0; i < arrayLen; i++){
                arr[i] = sc.nextInt();
            }
            finalRes += subArrayXor(arr, arrayLen, k);
        }
        System.out.println(finalRes);
    }
}
