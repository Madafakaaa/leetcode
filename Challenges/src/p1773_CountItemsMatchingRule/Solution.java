package p1773_CountItemsMatchingRule;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/3/10 20:03
 */
class Solution {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int res = 0;
        List<HashMap<String, String>> itemMaps = new ArrayList<>(items.size());
        HashMap<String, String> itemMap = new HashMap<>(3);
        for (List<String> item : items) {
            itemMap.put("type", item.get(0));
            itemMap.put("color", item.get(1));
            itemMap.put("name", item.get(2));
            if (itemMap.getOrDefault(ruleKey, "").equals(ruleValue)) {
                res++;
            }
            itemMap.clear();
        }
        return res;
    }
}