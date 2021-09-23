/*
 * Copyright (c) 2014 laidian. All Rights Reserved.
 * @author LYH
 * @date  2019-12-25 9:44
 */

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * @author LYH
 * @date 2019/12/25 9:44
 */
public class Test {

    public static void main(String[] args) throws IOException {
        /*System.out.println(System.currentTimeMillis());

        System.out.println(Instant.now().toEpochMilli());

        System.out.println(LocalDateTime.now());
        System.out.println(LocalDateTime.now().toInstant(ZoneOffset.of("+0")).toEpochMilli());

        System.out.println(LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli());
        //System.out.println(LocalDateTime.now().toInstant(ZoneOffset.of("-8")));


        System.out.println(LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli());*/
        Map<String, Boolean> deviceStatusMap = Maps.newHashMap();
        deviceStatusMap.put("11", true);

        deviceStatusMap.put("22", true);

        deviceStatusMap.put("33", false);

        Map<String, Object> stringObjectMap = Maps.newHashMap();
        stringObjectMap.put("11", 2);

        Map<String, Integer> map = Maps.newHashMap();

        System.out.println((int) map.values().stream().filter(num -> Objects.equals(num, 1)).count());
        System.out.println((int) map.values().stream().filter(num -> Objects.equals(num, 0)).count());
        List<Integer> numLimit = Lists.newArrayList();
        numLimit.add(1);
        numLimit.add(2);
        numLimit.add(3);
        if (numLimit.size() > 2) {
            // 进行list截取
            numLimit = numLimit.subList(0, 2);
        }
        System.out.println(numLimit);
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("1", "false");
        Boolean flag = Boolean.valueOf(hashMap.get("1").toString());
        System.out.println(flag);

        String temperature1 = Optional.ofNullable(hashMap.get("2")).orElse("").toString();
        System.out.println(temperature1);

        System.out.println("lyh_123".substring("lyh_123".lastIndexOf('_') + 1));
        System.out.println("lyh_123".substring("lyh_123".lastIndexOf("_") + 1));
    }

}