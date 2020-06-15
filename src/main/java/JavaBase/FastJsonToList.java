package JavaBase;

import com.alibaba.fastjson.TypeReference;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 633805 LYH
 * @version V1.0
 * @description FastJson转换成指定对象数组
 * @create 2019-03-01 11:55
 * @since 1.7
 */
public class FastJsonToList {
    public static void main(String[] args) {

        User user = new User("1", "lyh", 21, 1.1);
        List<User> list = new ArrayList<>();
        list.add(user);

        Result<List<User>> result= Result.ok(list);

        List<User> userList = null;
        //userList =JavaBase.JsonUtil.parseArray("["+JavaBase.JsonUtil.toJsonString(result.getData())+"]",JavaBase.Student.class);
       // userList = JavaBase.JsonUtil.parseAnyObject( "["+JavaBase.JsonUtil.toJsonString(result.getData())+"]",new TypeReference<List<JavaBase.Student>>(){});
        userList = JsonUtil.parseAnyObject( JsonUtil.toJsonString(result.getData()),new TypeReference<List<User>>(){});
        userList = result.getData();
        System.out.println(userList);


    }
}
