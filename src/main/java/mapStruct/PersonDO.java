package mapStruct;

import lombok.Data;

import java.util.Date;

/**
 * <p> write your description here
 *
 * @author 【千殇】（【罗玉华】qianshang.luo@tuya.com）
 * @since 2021/5/19 2:07 下午
 */
@Data
public class PersonDO {
    private Integer id;

    private String name;

    private int age;

    private Date birthday;

    //private String gender;
}
