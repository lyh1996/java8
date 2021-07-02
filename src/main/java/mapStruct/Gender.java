package mapStruct;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * <p> write your description here
 *
 * @author 【千殇】（【罗玉华】qianshang.luo@tuya.com）
 * @since 2021/5/19 2:19 下午
 */
public enum Gender {
    MALE(0, "男性"),
    WOMAN(1, "女性");

    private final Integer code;

    private final String desc;

    Gender(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    private static Map<Integer, Gender> enumMap = Stream
            .of(Gender.values()).collect(Collectors.toMap(Gender::getCode, Function.identity()));


    public static String getDesc(Integer code) {
        return enumMap.get(code).desc;
    }

}
