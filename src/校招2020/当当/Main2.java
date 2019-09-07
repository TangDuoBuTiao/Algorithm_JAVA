package 校招2020.当当;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        List<String> res = new ArrayList<>();
        for (int i = 0; i < s.length() - 2 && i < 4; i++) {
            for (int j = i + 1; i < i + 4 && j < s.length() - 1; j++) {
                for (int k = j + 1; k < j + 4 && k < s.length(); k++) {
                    String s1 = s.substring(0, i);
                    String s2 = s.substring(i, j);
                    String s3 = s.substring(j, k);
                    String s4 = s.substring(k);
                    if (check(new String[]{s1, s2, s3, s4})) {
                        res.add(s1 + "." + s2 + "." + s3 + "." + s4);
                    }
                }
            }
        }
        for (int i = 0; i < res.size(); i++) {
            if(i == res.size() - 1){
                System.out.print(res.get(i));
            }else{
                System.out.print(res.get(i) + ",");
            }

        }
    }

    public static boolean check(String[] strs) {
        for (String s : strs) {
            if (s.length() == 0 || s.length() > 3 || (s.charAt(0) == '0'
                    && s.length() > 1) || Integer.parseInt(s) > 255) {
                return false;
            }

        }
        return true;
    }
}
