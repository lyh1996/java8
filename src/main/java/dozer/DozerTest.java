package dozer;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

/**
 * @author 633805 LYH
 * @version V1.0
 * @description dozer的使用教程参考    https://blog.csdn.net/a258831020/article/details/48247187
 * @create 2019-05-20 10:53
 * @since 1.7
 */
public class DozerTest {

    public static void main(String[] args) {


        UserDO userDO = new UserDO();
        userDO.setUserName("lyh");
        userDO.setPassword("123");
        userDO.setUserAge(22);
        System.out.println(userDO);
        UserVO userVO = new UserVO();
        Mapper mapper = new DozerBeanMapper();
        mapper.map(userDO, userVO);
        System.out.println(userVO);

    }
}
