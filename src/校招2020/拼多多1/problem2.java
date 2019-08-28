package 校招2020.拼多多1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class problem2 {
    private static ArrayList<ArrayList<String>> lists = new ArrayList<>();

    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        fun(str, 0);
        if(lists.size() != 0){
            System.out.println(true);
        }else{
            System.out.println(false);
        }
//        for(int i = 0; i < lists.size(); i++){
//            ArrayList<String> list = lists.get(i);
//            int n = list.size();
//            if(list.get(0).charAt(0) == list.get(n - 1).charAt(list.get(n - 1).length() - 1)){
//                System.out.println(true);
//                return;
//            }
//        }
    }

    public static void fun(String[] str, int k) {
        if (k == str.length) {
            ArrayList<String> list = new ArrayList<>();
            for (int i = 0; i < str.length; i++) {
                list.add(str[i]);
            }
            lists.add(list);
        }
        for (int i = k; i < str.length; ++i) {
            if(k > 0 && judge(str[k - 1], str[i])){
                swap(str, k ,i);
                fun(str, k + 1);
                swap(str, k, i);
            }else if(k == 0){
                swap(str, k, i);
                fun(str, k + 1);
                swap(str, k, i);
            }
        }
    }
    private static void swap(String[] a, int s, int i){
        String t = a[s];
        a[s] = a[i];
        a[i] = t;
    }

    public static boolean judge(String s1, String s2){
        if(s1.charAt(s1.length()-1) == s2.charAt(0)){
            return true;
        }
        return false;
    }
}
