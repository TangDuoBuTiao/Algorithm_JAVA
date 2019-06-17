package 校招真题2018.爱奇艺;
/*
 * 问题描述：对于同一个字母,他只想保留第一次出现并删除掉后面出现的字母。请帮助牛牛完成对s的操作。
 * 输入：输入包括一个字符串s,s的长度length(1 ≤ length ≤ 1000),s中的每个字符都是小写的英文字母('a' - 'z')
 * 输出：输出一个字符串,表示满足牛牛要求的字符串
 * Eg:banana
 *    ban
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class 删除重复字符串 {

    public static void main(String[] args) throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String str = input.readLine();
        Map<Character, Integer> map = new LinkedHashMap<>();
        for(int i = 0; i < str.length(); i++){
            map.put(str.charAt(i), 1);
        }
        for(char key : map.keySet()){
            System.out.print(key);
        }
    }
}
