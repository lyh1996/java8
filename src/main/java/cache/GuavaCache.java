package cache;

/**
 * @author 633805 LYH
 * @version V1.0
 * @description 对类的描述
 * @create 2019-06-17 15:16
 * @since 1.7
 */
public class GuavaCache extends SuperBaseGuavaCache<String, Object> {


    /**
     * 返回加载到内存中的数据，从redis中查找
     *
     * @param key key值
     * @return
     */
    @Override
    Object getLoadData(String key) {
        //redis获取然后存入本地缓存

        return null;
    }

    /**
     * 调用getLoadData返回null值时自定义加载到内存的值
     * @param key key值
     * @return
     */
    @Override
    Object getLoadDataIfNull(String key) {
        //数据库中查找然后进入redis然后进入本地缓存

        return null;
    }
}
