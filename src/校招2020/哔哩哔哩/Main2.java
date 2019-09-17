package 校招2020.哔哩哔哩;


import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int s = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int left = 0;
        int right = 0;
        int money = 0;
        int min = n;
        for (int i = 0; i < n; i++) {
            money += arr[i];
        }
        if (money < s) {
            System.out.println(-1);
            return;
        }
        money = 0;
        while (right < n) {
            money += arr[right];
            if (money >= s) {
                min = Math.min(min, right - left + 1);
            }
            while (left < n && money >= s) {
                money -= arr[left];
                left++;
            }
            if (money < s) {
                right++;
            }
        }
        System.out.println(min);
    }
}
