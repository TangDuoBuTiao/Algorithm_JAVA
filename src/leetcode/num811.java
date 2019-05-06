package leetcode;
/*
 * 《子域名访问计数》
 */

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

public class num811 {
    public static List<String> subdomainVisits(String[] cpdomains) {
        int num;
        String str;
        List<String> list = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < cpdomains.length; i++) {
            num = Integer.valueOf(cpdomains[i].substring(0, cpdomains[i].indexOf(" ")));
            str = cpdomains[i].substring(cpdomains[i].indexOf(" ") + 1);
            while (!str.equals("")) {
                if (map.containsKey(str)) {
                    map.put(str, map.get(str) + num);
                } else {
                    map.put(str, num);
                }
                if (str.contains(".")) {
                    str = str.substring(str.indexOf(".") + 1);
                } else {
                    break;
                }
            }
        }
        for (String skey : map.keySet()) {
            list.add(map.get(skey) + " " + skey);
            System.out.println(map.get(skey) + " " + skey);
        }
        return list;
    }

    public static void main(String[] args) {
        String[] str = {"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"};
        subdomainVisits(str);
    }
}
