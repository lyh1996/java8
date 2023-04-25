/*
package util;

import cn.hutool.json.JSONUtil;
import com.ak.cepf.core.utils.RequestUtil;
import com.platform.warehouse.api.enums.redis.RedisKeyEnum;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

*/
/**
 * <p> 请求重复校验
 *
 * @author 【LYH】（【罗玉华】luoyuhua@lingxing.com）
 * @date 2022/6/2 10:16
 *
 * <p> 判断用户请求 是否重复
 * @param obj
 * @param methodName
 * @param redisKeyEnum
 * @return boolean
 * @author [LYH] ([罗玉华]luoyuhua@lingxing.com)
 * @date 2022/6/2 10:25
 *
 * <p> 判断用户请求 是否重复
 * @param obj
 * @param redisKeyEnum
 * @param excludeKeys  对象中需要排除的key
 * @return boolean
 * @author [LYH] ([罗玉华]luoyuhua@lingxing.com)
 * @date 2022/6/2 10:25
 *//*

@Component
public class RedisReqLimitManager {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    */
/**
 * <p> 判断用户请求 是否重复
 *
 * @param obj
 * @param methodName
 * @param redisKeyEnum
 * @return boolean
 * @author [LYH] ([罗玉华]luoyuhua@lingxing.com)
 * @date 2022/6/2 10:25
 *//*

    public boolean isConsiderDup(Object obj, String methodName, RedisKeyEnum redisKeyEnum) {
        // 将对象转换成json串
        String req = JSONUtil.toJsonStr(obj);
        String dedupMD5 = new ReqDedupUtils().dedupParamMD5(req);
        String key = "dedup:U=" + RequestUtil.getCurrentUser() + "M=" + methodName + "P=" + dedupMD5;
        // 得到业务标识的redisKey
        String redisKey = redisKeyEnum.getRedisKey(key);
        // 过期时间内的重复请求会认为重复
        long expireTime = redisKeyEnum.getMillis();
        long expireAt = System.currentTimeMillis() + expireTime;
        String val = "expireAt@" + expireAt;
        // 当且不存在设置成功
        Boolean firstSet = stringRedisTemplate.opsForValue().setIfAbsent(redisKey, val, redisKeyEnum.getTimeOut(), redisKeyEnum.getUnit());
        final boolean isConsiderDup;
        if (firstSet != null && firstSet) {
            isConsiderDup = false;
        } else {
            isConsiderDup = true;
        }
        return isConsiderDup;
    }

    */
/**
 * <p> 判断用户请求 是否重复
 *
 * @param obj
 * @param redisKeyEnum
 * @param excludeKeys  对象中需要排除的key
 * @return boolean
 * @author [LYH] ([罗玉华]luoyuhua@lingxing.com)
 * @date 2022/6/2 10:25
 *//*

    public boolean isConsiderDup(Object obj, RedisKeyEnum redisKeyEnum, String... excludeKeys) {
        // 将对象转换成json串
        String req = JSONUtil.toJsonStr(obj);
        String dedupMD5 = new ReqDedupUtils().dedupParamMD5(req, excludeKeys);
        String key = "dedup:U=" + RequestUtil.getCurrentUser() + "P=" + dedupMD5;
        // 得到业务标识的redisKey
        String redisKey = redisKeyEnum.getRedisKey(key);
        // 过期时间内的重复请求会认为重复
        long expireTime = redisKeyEnum.getMillis();
        long expireAt = System.currentTimeMillis() + expireTime;
        String val = "expireAt@" + expireAt;
        // 当且不存在设置成功
        Boolean firstSet = stringRedisTemplate.opsForValue().setIfAbsent(redisKey, val, redisKeyEnum.getTimeOut(), redisKeyEnum.getUnit());
        final boolean isConsiderDup;
        if (firstSet != null && firstSet) {
            isConsiderDup = false;
        } else {
            isConsiderDup = true;
        }
        return isConsiderDup;
    }
}
*/
