package 校招2020.五八同城;

import java.util.HashSet;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] s = str.split(",");
        HashSet<String> set = new HashSet<>();
        for(int i = 0; i < s.length; i++){
            set.add(s[i]);
        }
        System.out.println(set.size());
    }
}
