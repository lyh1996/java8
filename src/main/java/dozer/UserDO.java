package dozer;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author 633805 LYH
 * @version V1.0
 * @description 对类的描述
 * @create 2019-05-20 10:53
 * @since 1.7
 */
@Setter
@Getter
@ToString
public class UserDO implements Serializable {


    private static final long serialVersionUID = 4502180548625033005L;
    /**
     * 用户名
     */
    private String userName;

    /**
     * 密码
     */
    private String password;

    /**
     * 用户年龄
     */
    private Integer userAge;

}
