package testMap;

import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author 【LYH】（【罗玉华】luoyuhua@lingxing.com）
 * @date 2023/04/25 09:45
 **/
public class MapSplitTest {
    /**
     * 将map切成段--工具类
     *
     * @param splitMap 被切段的map
     * @param splitNum 每段的大小
     */
    public static <k, v> List<Map<k, v>> mapSplit(Map<k, v> splitMap, int splitNum) {
        if (splitMap == null || splitNum <= 0) {
            List<Map<k, v>> list = new ArrayList<>();
            list.add(splitMap);
            return list;
        }
        Set<k> keySet = splitMap.keySet();
        Iterator<k> iterator = keySet.iterator();
        int i = 1;
        List<Map<k, v>> total = new ArrayList<>();
        Map<k, v> tem = new HashMap<>();
        while (iterator.hasNext()) {
            k next = iterator.next();
            tem.put(next, splitMap.get(next));
            if (i == splitNum) {
                total.add(tem);
                tem = new HashMap<>();
                i = 0;
            }
            i++;
        }
        if (!CollectionUtils.isEmpty((Collection<?>) tem)) {
            total.add(tem);
        }
        return total;
    }
}
