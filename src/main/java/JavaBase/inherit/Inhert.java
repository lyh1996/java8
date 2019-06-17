package JavaBase.inherit;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author 633805 LYH
 * @version V1.0
 * @description 对类的描述
 * @create 2019-06-15 14:21
 * @since 1.7
 */
@Setter
@Getter
@ToString
public class Inhert implements Serializable {


    private static final long serialVersionUID = 3810767556311964103L;
    String uname;
    String sex;
}
