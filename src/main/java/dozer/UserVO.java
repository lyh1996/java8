package dozer;

import lombok.Data;

import java.io.Serializable;

/**
 * @author 633805 LYH
 * @version V1.0
 * @description 对类的描述
 * @create 2019-05-20 10:53
 * @since 1.7
 */
@Data
public class UserVO implements Serializable {

    private static final long serialVersionUID = 1088898730642333629L;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 用户年龄
     */
    private Integer userAge;
}
