package leetcode;
/*
 * 《基于时间的键值存储》
 */

import java.util.HashMap;

public class num981_基于时间的键值存储 {
    HashMap<HashMap<String, Integer>, String> map1 = new HashMap<>();
    HashMap<String, Integer> map2 = new HashMap<>();

    public void set(String key, String value, int timestamp) {
        map2.put(key, timestamp);
        map1.put(map2, value);
    }

    public String get(String key, int timestamp) {
        String val = "";
        int time = 0;
        int tmp = 0;
        for (HashMap.Entry<HashMap<String, Integer>, String> entry : map1.entrySet()) {
            if (entry.getKey().containsKey(key)) {
                tmp = entry.getKey().get(key);
                if (tmp <= timestamp && tmp > time) {
                    val = entry.getValue();
                    time = tmp;
                }
            }
        }
        return val;
    }

    public static void main(String[] args) {
        num981_基于时间的键值存储 n = new num981_基于时间的键值存储();
        n.set("love", "high", 10);
        n.set("love", "low", 20);
        System.out.println(n.get("love",5));
        System.out.println(n.get("love",10));
    }

}
