package 校招2020.哔哩哔哩;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] s = str.split(",");
        //计算
        Arrays.sort(s, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2 + o1).compareTo(o1 + o2);
            }
        });
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length; i++){
            sb.append(s[i]);
        }
        String res = sb.toString();
        if(res != null && res.charAt(0) == '0'){
            System.out.println(0);
        }
        System.out.println(res);
    }

}
