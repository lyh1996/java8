package tool;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

/**
 * <p> 简单的内存分页工具类
 *
 * @author 【千殇】（【罗玉华】qianshang.luo@tuya.com）
 * @since 2021/9/11 12:32 上午
 */
public class PageUtils {

    /**
     * <p> 手动分页
     *
     * @param datas
     * @param pageSize
     * @param pageNo
     * @return java.util.List<T>
     * @author [千殇] ([罗玉华]qianshang.luo@tuya.com)
     * @date 2021/9/11 12:33 上午
     */
    public static <T> List<T> getPageSizeDataForRelations(List<T> datas, int pageSize, int pageNo) {
        // 起始截取数据位置
        int startNum = (pageNo - 1) * pageSize + 1;
        if (startNum > datas.size()) {
            return null;
        }
        List<T> res = new ArrayList<>();
        int rum = datas.size() - startNum;
        if (rum < 0) {
            return null;
        }
        if (rum == 0) {
            //说明正好是最后一个了
            int index = datas.size() - 1;
            res.add(datas.get(index));
            return res;
        }
        if (rum / pageSize >= 1) {
            // 剩下的数据还够1页，返回整页的数据
            for (int i = startNum; i < startNum + pageSize; i++) {
                //截取从startNum开始的数据
                res.add(datas.get(i - 1));
            }
            return res;
        } else if ((rum / pageSize == 0) && rum > 0) {
            //不够一页，直接返回剩下数据
            for (int j = startNum; j <= datas.size(); j++) {
                res.add(datas.get(j - 1));
            }
            return res;
        } else {
            return null;
        }
    }


    public static void main(String[] args) {
        List<String> list = Lists.newArrayList();
        list.add("1111");
        list.add("2222");
        list.add("3333");
        System.out.println(getPageSizeDataForRelations(list, 2, 1));
    }
}
