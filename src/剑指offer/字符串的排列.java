package 剑指offer;
/*
 * 问题： 输入一个字符串, 按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class 字符串的排列 {

    //给输入的str字符串中的字符进行全排列
    public static ArrayList<String> permutation(String str) {
        ArrayList<String> list = new ArrayList<>();
        Set<String> set = null;
        if (str == null) { //如果字符串为空，直接返回
            return list;
        }
        permutation(str.toCharArray(), 0, list); //否则将字符串转换为字符数字，并从字符0位置开始进行全排列
        set = new HashSet<>(list);
        return list;
    }

    private static void permutation(char[] chars, int pos, ArrayList<String> list) {
        if (pos == chars.length - 1) {
            list.add(new String(chars));
        }
        for (int i = pos; i < chars.length; i++) {
            swap(chars, i, pos);   //首部字符和它后面的字符（包括自己）进行交换
            permutation(chars, pos + 1, list);    //递归求后面的字符的排列
            swap(chars, i, pos);    //由于前面交换了一下，所以chs的内容改变了，我们要还原回来
        }
    }

    public static void swap(char[] arr, int i, int j) {
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        ArrayList<String> ans = new ArrayList<>();
        ans = permutation("abc");
        for (int i = 0; i < ans.size(); i++) {
            System.out.println(ans.get(i));
        }
    }
}
