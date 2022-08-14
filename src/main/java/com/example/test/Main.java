package com.example.test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long[] nums = new long[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        long ans = 0;
        for (int j = 1; j < n - 1; j++) {
            HashMap<Long, Integer> map = new HashMap<>();
            for (int x = j + 1; x < n; x++) {
                map.put(nums[x], map.getOrDefault(nums[x], 0) + 1);
            }
            HashMap<Long, Integer> set = new HashMap<>();
            for (int i = 0; i < j; i++) {
                set.put(nums[i], set.getOrDefault(nums[i], 0) + 1);
            }
            for (Map.Entry<Long, Integer> entry : set.entrySet()) {
                ans += map.getOrDefault(3 * nums[j] - entry.getKey(), 0) * entry.getValue();
            }
        }

        System.out.println(ans);
    }
}
