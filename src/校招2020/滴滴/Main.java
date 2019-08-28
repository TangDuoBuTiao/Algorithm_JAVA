package 校招2020.滴滴;

/*
 * 算式转移
 */

import java.util.Scanner;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        String[] arr = new String[2 * len - 1];
        for (int i = 0; i < 2 * len - 1; i++) {
            arr[i] = sc.next();
        }

        //计算
        ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
        ScriptEngine scriptEngine = scriptEngineManager.getEngineByName("nashorn");
        String expression = arr2str(arr);
        String result = null;
        try {
            result = String.valueOf(scriptEngine.eval(expression));
        } catch (ScriptException e) {
            e.printStackTrace();
        }
        for (int j = 2; j <= arr.length - 1; j = j + 2) {

            int i = j;
            while (i >= 2) {
                if (Integer.valueOf(arr[i]) < Integer.valueOf(arr[i - 2])) {
                    swap(arr, i, i - 2);
                    String tmp = null;
                    try {
                        tmp = String.valueOf(scriptEngine.eval(arr2str(arr)));
                    } catch (ScriptException e) {
                        e.printStackTrace();
                    }
                    if (!tmp.contains(result) && !result.contains(tmp)) {
                        swap(arr, i, i - 2);
                    }
                    i = i - 2;
                } else {
                    break;
                }
            }
        }

        System.out.println(arr2str(arr));
    }

    public static String arr2str(String[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            sb.append(" ");
        }
        return sb.toString().trim();
    }

    public static void swap(String[] str, int i, int j) {
        String tmp = str[i];
        str[i] = str[j];
        str[j] = tmp;
    }

}
