package 校招2020.云从科技;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[][] arr = new double[16][2];
        String[] str = new String[16];
        for (int i = 0; i < 16; i++) {
            str[i] = sc.nextLine();
        }
        for (int i = 0; i < str.length; i++) {
            String[] s = str[i].split(",");
            arr[i][0] = Double.valueOf(s[0]);
            arr[i][1] = Double.valueOf(s[1]);
        }


        //计算
        double minx = Double.MAX_VALUE;
        double miny = Double.MAX_VALUE;
        double maxx = Double.MIN_VALUE;
        double maxy = Double.MIN_VALUE;
        for (int i = 0; i < 16; i++) {
            minx = Math.min(minx, arr[i][0]);
            maxx = Math.max(maxx, arr[i][0]);
            miny = Math.min(miny, arr[i][1]);
            maxy = Math.max(maxy, arr[i][1]);
        }
        int chang = (int)(maxy - miny);
        int kuan = (int)(maxx - minx);
        if (chang >= kuan) {
            System.out.print(chang);
            System.out.print(",");
            System.out.print(kuan);
        }else{
            System.out.print(kuan);
            System.out.print(",");
            System.out.print(chang);
        }
    }
}
