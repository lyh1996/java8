package clone;

/**
 * @author 633805 LYH
 * @version V1.0
 * @description 对类的描述
 * @create 2019-09-20 14:32
 * @since 1.7
 */
public class Address implements Cloneable{

    private String city;

    public String getCity() {
        return city;
    }

    public Address(String city) {
        this.city = city;
    }

    public Address setCity(String city) {
        this.city = city;
        return this;
    }

    @Override
    protected Object clone() {
        Address addr = null;
        try {
            addr = (Address) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return addr;
    }

    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                '}';
    }
}
