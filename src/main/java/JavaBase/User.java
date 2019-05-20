package JavaBase;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author 633805 LYH
 * @version V1.0
 * @description 对类的描述
 * @create 2019-02-26 14:23
 * @since 1.7
 */
public class User implements Serializable{


    private static final long serialVersionUID = -4011696993297127295L;
    private String uid;

    private String name;

    private Integer age;

    public User() {
    }

    public User(String uid, String name, Integer age) {
        this.uid = uid;
        this.name = name;
        this.age = age;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(uid, user.uid) &&
                Objects.equals(name, user.name) &&
                Objects.equals(age, user.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uid, name, age);
    }

    @Override
    public String toString() {
        return "JavaBase.User(uid=" + this.getUid() + ", name=" + this.getName() + ", age=" + this.getAge() + ")";
    }

}
