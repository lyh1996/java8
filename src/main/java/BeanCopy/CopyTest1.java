package BeanCopy;

import JavaBase.User;
import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * @author 633805 LYH
 * @version V1.0
 * @description 对类的描述
 * @create 2019-09-24 8:28
 * @since 1.7
 */
@ToString
@Data
public class CopyTest1 {
    public String outerName;
    public CopyTest1.InnerClass innerClass;
    public List<InnerClass> clazz;
    public User user;

    @ToString
    @Data
    public static class InnerClass {
        public String InnerName;
    }
}
