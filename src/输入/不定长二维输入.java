package 输入;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 不定长二维输入 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String[]> list = new ArrayList<>();
        while (true) {
            if(sc.nextLine().equals("")){
                break;
            }else{
                String str = sc.nextLine();
                list.add(str.split(" "));
            }
        }
        int[][] arr = new int[list.size()][list.get(0).length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = Integer.valueOf(list.get(i)[j]);
            }
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

    }
}
