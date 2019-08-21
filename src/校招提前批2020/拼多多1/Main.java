package 校招提前批2020.拼多多1;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] li = new int[N];
        int[] wi = new int[N];
        for (int i = 0; i < N; i++) {
            li[i] = sc.nextInt();
        }
        for (int i = 0; i < N; i++) {
            wi[i] = sc.nextInt();
        }
        int flag = -1;
        for(int i = 1; i < li.length; i++){
            if(li[i] <= li[i - 1]){
                flag = i;
                break;
            }
        }
        Arrays.sort(wi);
        int pos = -1;
        if(flag == li.length - 1){
            li[flag] = wi[wi.length - 1];
        }else{
            pos = binarySearch(wi, li[flag + 1]);
            if(wi[pos] <= li[flag - 1]){
                pos = -1;
            }
        }
        if(pos == -1){
            System.out.println("NO");
        }else{
            for(int i = 0; i < li.length - 1; i++){
                System.out.println(li[i] + " ");
            }
            System.out.println(li[li.length - 1]);
        }
    }

    public static int binarySearch(int[] a, int target){
        int l = 0;
        int r = a.length - 1;
        while(l <= r){
            int mid = l + (r - l) / 2;
            if(target <= a[mid]){
                l = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        return r < 0 ? -1 : r;
    }
}
