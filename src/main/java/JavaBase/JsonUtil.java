package JavaBase;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.util.List;

/**
 * @author 320238 -营运移动-瞿诗波
 * @version 1.0.0
 * @description 与 “对象”等相关的函数
 * @update 2017 -10-23 03:14:13
 * @since 2016 -04-22 19:25:11
 */
public class JsonUtil {

    /**
     * The constant serializerFeatures.
     */
/* 序列化规则 */
    static SerializerFeature[] serializerFeatures = new SerializerFeature[] {
            // 空的处理
            SerializerFeature.WriteNullListAsEmpty, // List字段，若为null,输出为[]
            // 格式化
            SerializerFeature.WriteMapNullValue, // 输出为空的属性
            SerializerFeature.DisableCircularReferenceDetect// 非引用模式
    };

    /**
     * @param object 参数说明
     * @return the string
     * @description 这里用一句话描述这个方法的作用
     * @author 333839 -PDA-luopan
     * @update 2017 -10-23 03:14:13
     * @version V1.0
     */
/* 对象 -> JSON字符串 */
    public static String toJsonString(Object object) {
        return JSON.toJSONString(object, serializerFeatures);
    }

    /**
     * @param object 参数说明
     * @return the string
     * @description 这里用一句话描述这个方法的作用
     * @author 333839 -PDA-luopan
     * @update 2017 -10-23 03:14:13
     * @version V1.0
     */
/* 对象 -> JSON字符串 */
    public static String toJsonStringZ(Object object) {
        return toJsonString(object).replaceAll("\"", "\\\\\"");
    }

    /**
     * The constant features.
     */
/* 反序列化规则 */
    static Feature[] features = new Feature[] {

    };

    /**
     * @param input 参数说明
     * @return the json object
     * @description 这里用一句话描述这个方法的作用
     * @author 333839 -PDA-luopan
     * @update 2017 -10-23 03:14:13
     * @version V1.0
     */
/* JSON字符串 -> JSONObject */
    public static JSONObject parseObject(String input) {
        return JSON.parseObject(input);
    }

    /**
     * @param input 参数说明
     * @return the json array
     * @description 这里用一句话描述这个方法的作用
     * @author 333839 -PDA-luopan
     * @update 2017 -10-23 03:14:13
     * @version V1.0
     */
/* JSON字符串 -> JSONArray */
    public static JSONArray parseArray(String input) {
        return JSON.parseArray(input);
    }

    /**
     * @param <T>   the type parameter
     * @param input 参数说明
     * @param clazz 参数说明
     * @return the t
     * @description 这里用一句话描述这个方法的作用
     * @author 333839 -PDA-luopan
     * @update 2017 -10-23 03:14:13
     * @version V1.0
     */
/* JSON字符串 -> 对象 */
    public static <T> T parseObject(String input, Class<T> clazz) {
        return JSON.parseObject(input, clazz, features);
    }

    /**
     * @param <T>   the type parameter
     * @param input 参数说明
     * @param clazz 参数说明
     * @return the list
     * @description 这里用一句话描述这个方法的作用
     * @author 333839 -PDA-luopan
     * @update 2017 -10-23 03:14:13
     * @version V1.0
     */
/* JSON字符串 -> List */
    public static <T> List<T> parseArray(String input, Class<T> clazz) {
        return JSON.parseArray(input, clazz);
    }

    /**
     * @param <T>   the type parameter
     * @param input 参数说明
     * @param type  参数说明
     * @return the t
     * @description 这里用一句话描述这个方法的作用
     * @author 333839 -PDA-luopan
     * @update 2017 -10-23 03:14:13
     * @version V1.0
     */
/* JSON字符串 -> 对象 升级版(支持泛型) */
    public static <T> T parseAnyObject(String input, TypeReference<T> type) {
        return JSON.parseObject(input, type, features);
    }

    /**
     * @param <T>        the type parameter
     * @param jsonObject 参数说明
     * @param clazz      参数说明
     * @return the t
     * @description 这里用一句话描述这个方法的作用
     * @author 333839 -PDA-luopan
     * @update 2017 -10-23 03:14:13
     * @version V1.0
     */
/* JSONObject -> 对象 */
    public static <T> T toJavaObject(JSONObject jsonObject, Class<T> clazz) {
        return JSON.toJavaObject(jsonObject, clazz);
    }

    /**
     * @param javaObject 参数说明
     * @return the json object
     * @description 这里用一句话描述这个方法的作用
     * @author 333839 -PDA-luopan
     * @update 2017 -10-23 03:14:13
     * @version V1.0
     */
/* 对象 -> JSONObject */
    public static JSONObject toJsonObject(Object javaObject) {
        return (JSONObject) JSONObject.toJSON(javaObject);
    }

    /**
     * @param <T>       the type parameter
     * @param jsonArray 参数说明
     * @param clazz     参数说明
     * @return the list
     * @description 这里用一句话描述这个方法的作用
     * @author 333839 -PDA-luopan
     * @update 2017 -10-23 03:14:13
     * @version V1.0
     */
/* JSONArray -> List */
    public static <T> List<T> parseArray(Object jsonArray, Class<T> clazz) {
        String jsonStr = toJsonString(jsonArray);
        return JSON.parseArray(jsonStr, clazz);

    }
}
