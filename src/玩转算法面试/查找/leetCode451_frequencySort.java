package 玩转算法面试.查找;
/*
 * 给定一个字符串，请将字符串里的字符按照出现的频率降序排列。
 * 输入:"tree"
   输出:"eert"
   解释:
   'e'出现两次，'r'和't'都只出现一次。
   因此'e'必须出现在'r'和't'之前。此外，"eetr"也是一个有效的答案。
*/

import java.util.Arrays;

public class leetCode451_frequencySort {

    public static String frequencySort(String s) {
        StringBuilder sb = new StringBuilder();
        int[] freq = new int[256];
        char[] sArr = s.toCharArray();
        for (int i = 0; i < sArr.length; i++) {
            freq[sArr[i]]++;
        }
        int[] freqCopy = freq.clone();
        Arrays.sort(freq);
        for (int i = 255; i >= 0 && freq[i] > 0; i--) {  //直接跳过为0的
            for (int j = 0; j < 256; j++) {
                if (freq[i] == freqCopy[j]) {
                    while (freqCopy[j] != 0) {
                        sb.append((char) j);
                        freqCopy[j]--;
                    }
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(frequencySort("tree"));
    }
}
