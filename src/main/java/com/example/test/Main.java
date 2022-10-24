package com.example.test;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), k = scanner.nextInt();
        char[] chars = scanner.next().toCharArray();
        int[][] dp = new int[n][k + 1];
        for (int i = 0; i < n; i++) {
            if ((chars[i] - '0') % k == 0) {
                dp[i][1] = 1;
            }
        }
        for (int i = 1; i < n; i++) {
            int tmp = chars[i] - '0';
            if (tmp % k == 0) {
                for (int p = 0; p < i; p++) {
                    for (int j = 2; j <= k; j++) {
                        dp[i][j] += dp[p][j - 1];
                    }
                }
            }
            for (int m = 0; m < i; m++) {
                tmp = (chars[m] - '0') * 10 + chars[i] - '0';
                if (tmp % k == 0) {
                    dp[i][2]++;
                    for (int p = 0; p < m; p++) {
                        for (int j = 3; j <= k; j++) {
                            dp[i][j] += dp[p][j - 2];
                        }
                    }
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += Arrays.stream(dp[i]).sum();
        }
        System.out.println(ans);
    }
}
