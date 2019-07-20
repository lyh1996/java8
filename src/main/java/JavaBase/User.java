package JavaBase;

import lombok.*;

import java.io.Serializable;

/**
 * @author 633805 LYH
 * @version V1.0
 * @description 对类的描述
 * @create 2019-02-26 14:23
 * @since 1.7
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString(callSuper =true)
public class User implements Serializable{


    private static final long serialVersionUID = -4011696993297127295L;
    private String uid;

    private String name;

    private Integer age;


}
