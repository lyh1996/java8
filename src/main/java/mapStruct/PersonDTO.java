package mapStruct;

import lombok.Data;

import java.util.Date;

/**
 * <p> write your description here
 *
 * @author 【千殇】（【罗玉华】qianshang.luo@tuya.com）
 * @since 2021/5/19 2:10 下午
 */
@Data
public class PersonDTO {

    private String userName;

    private Integer age;

    private Date birthday;

    //private Gender gender;

}
