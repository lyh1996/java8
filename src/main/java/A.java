import JavaBase.User;
import com.google.common.collect.Lists;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * <p> write your description here
 *
 * @author 【千殇】（【罗玉华】qianshang.luo@tuya.com）
 * @since 2021/11/3 6:29 下午
 */
public class A {

    public static void main(String[] args) {
        List<User> existRepairs = Lists.newArrayList();
        // retryCount和groupId的映射关系
        Map<Integer, String> retryCountMap = existRepairs.stream()
                .collect(Collectors.toMap(User::getAge, User::getName, (k1, k2) -> k2));

        System.out.println(Objects.isNull(retryCountMap.get(1)));
    }
}
