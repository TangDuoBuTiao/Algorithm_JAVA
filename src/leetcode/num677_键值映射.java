package leetcode;
/*
 * 《键值映射》
 */

import java.util.HashMap;
import java.util.Map;

public class num677_键值映射 {
    Map<String, Integer> map = new HashMap<>();

    public void insert(String key, int val) {
        map.put(key, val);
    }

    public int sum(String prefix) {
        int ans = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getKey().indexOf(prefix) == 0) {
                ans += entry.getValue();
            }
        }
        return ans;
    }
}
