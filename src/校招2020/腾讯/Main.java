package 校招2020.腾讯;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[][] = new int[n][5];
        int minx1 = Integer.MAX_VALUE;
        int miny1 = Integer.MAX_VALUE;
        int maxx2 = Integer.MIN_VALUE;
        int maxy2 = Integer.MIN_VALUE;
        int maxc = Integer.MIN_VALUE;
        int minc = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
            arr[i][2] = sc.nextInt();
            arr[i][3] = sc.nextInt();
            arr[i][4] = sc.nextInt();
            maxc = Math.max(maxc, arr[i][4]);
            minc = Math.min(minc, arr[i][4]);

            minx1 = Math.min(minx1, arr[i][0]);
            miny1 = Math.min(miny1, arr[i][1]);
            maxx2 = Math.max(maxx2, arr[i][2]);
            maxy2 = Math.max(maxy2, arr[i][3]);
        }
        int[][] dp = new int[maxy2 - miny1][maxx2 - minx1];
        for (int i = 0; i < n; i++) {
            for (int j = arr[i][0]; j < arr[i][2]; j++) {
                for (int k = arr[i][1]; k < arr[i][3]; k++) {
                    dp[k - miny1][j - minx1] = arr[i][4];
                }
            }
        }
        int max = 0;
        for (int i = minc; i <= maxc; i++) {
            max=Math.max(maximalRectangle(dp, i), max);
        }
        System.out.println(max);

    }

    public static int maximalRectangle(int[][] matrix, int n) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int[] height = new int[matrix[0].length];
        int globalmax = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == n) height[j]++;
                else height[j] = 0;
            }
            globalmax = Math.max(globalmax, maxrow(height));
        }
        return globalmax;
    }

    public static int maxrow(int[] height) {
        Stack<Integer> st = new Stack<>();
        int localmax = 0;
        for (int i = 0; i <= height.length; i++) {
            int h = (i == height.length) ? 0 : height[i];
            while (!st.isEmpty() && height[st.peek()] >= h) {
                int maxheight = height[st.pop()];
                int area = st.isEmpty() ? i * maxheight : maxheight * (i - st.peek() - 1);
                localmax = Math.max(localmax, area);
            }
            st.push(i);
        }
        return localmax;
    }
}
