package 校招提前批2020.拼多多1;

import java.util.Scanner;

public class 严格升序 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] numsa = null;
        String[] numsb = null;
        numsa = sc.nextLine().split(" ");
        numsb = sc.nextLine().split(" ");
        int numa[] = new int[numsa.length];
        for (int i = 0; i < numa.length; i++) {
            numa[i] = Integer.valueOf(numsa[i]);
        }

        int numb[] = new int[numsb.length];
        for (int i = 0; i < numb.length; i++) {
            numb[i] = Integer.valueOf(numsb[i]);
        }

        //找到ta
        int index = -1;
        int l = Integer.MIN_VALUE;
        int r = Integer.MAX_VALUE;
        for (int i = 0; i < numa.length; i++) {
            if (i == 0 && numa[i] > numa[i + 1]) {
                index = i;
                r = numa[i + 1];
            } else if (i == numa.length - 1 && numa[i] < numa[i - 1]) {
                index = i;
                l = numa[i - 1];
            } else if (i != 0 && i != numa.length - 1 && numa[i] <= numa[i - 1]) {
                index = i;
                l = numa[i - 1];
                r = numa[i + 1];
            } else {
                continue;
            }
        }
        //找到比l大，比r小的，且最大
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < numb.length; i++) {
            if (numb[i] > l && numb[i] < r) {
                max = Math.max(max, numb[i]);
            }
        }
        if (max == Integer.MIN_VALUE) {
            if(index == 1){
                for(int i = 0; i < numb.length; i++){
                    if(numb[i] < numa[index]){
                        max = Math.max(max, numb[i]);
                    }
                }
            }else{
                System.out.println("NO");
                return;
            }
        }
        numa[index] = max;
        for (int i = 0; i < numa.length; i++) {
            System.out.print(numa[i] + " ");
        }
    }

}
