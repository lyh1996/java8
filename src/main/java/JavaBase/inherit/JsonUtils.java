package JavaBase.inherit;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.apache.commons.lang3.StringUtils;

/**
 * @author 633805 LYH
 * @version V1.0
 * @description 对类的描述
 * @create 2019-06-15 14:37
 * @since 1.7
 */
public class JsonUtils {

    /**
     * 转换成json
     * 默认将class标记序列化进去
     */
    public static String toJsonString(Object obj) {
        return toJsonString(obj,true);
    }

    /**
     * 转换成json
     */
    public static String toJsonString(Object obj,boolean seralizerClass) {
        if(obj != null) {
            if(obj instanceof String && StringUtils.isBlank((String) obj)) {
                return "";
            }
            try {
                if(seralizerClass) {
                    return JSON.toJSONString(obj, SerializerFeature.WriteClassName);
                } else {
                    return JSON.toJSONString(obj);
                }
            } catch(Exception e) {
                return "null";
            }
        }
        return "null";
    }

    /**
     * json转javaBean对象
     */
    public static Object jsonParseObject(String json) {
        if(StringUtils.isBlank(json)) {
            return "";
        } else if(StringUtils.equalsIgnoreCase(json, "null")) {
            return null;
        }
        return JSON.parse(json);
    }

    /**
     * json转javaBean对象
     * @param json
     * @param clazz
     * @return 如果为null、空字符串或者'null'字符串，将返回null
     */
    public static <T> T toObject(String json, Class<T> clazz) {
        if (StringUtils.isBlank(json)) {
            return null;
        } else if (json.equalsIgnoreCase("null")) {
            return null;
        }

        return JSON.parseObject(json, clazz);
    }

}
