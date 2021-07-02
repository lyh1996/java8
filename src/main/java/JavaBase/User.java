package JavaBase;

import java.io.Serializable;

/**
 * @author 633805 LYH
 * @version V1.0
 * @description 对类的描述
 * @create 2019-02-26 14:23
 * @since 1.7
 */
public class User implements Serializable {


    private static final long serialVersionUID = -4011696993297127295L;
    private String uid;

    private String name;

    private Integer age;

    private Double money;

    /**
     * 创建时间
     */
   /* @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date createTime;*/
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

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public User(String uid, String name, Integer age, Double money) {
        this.uid = uid;
        this.name = name;
        this.age = age;
        this.money = money;
    }

    public User() {
    }


}
