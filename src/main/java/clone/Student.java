package clone;

/**
 * @author 633805 LYH
 * @version V1.0
 * @description 对类的描述
 * @create 2019-09-20 14:25
 * @since 1.7
 */
public class Student implements Cloneable {

    Address address;

    private int number;

    public int getNumber() {
        return number;
    }

    public Student setNumber(int number) {
        this.number = number;
        return this;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Student student;
        student = (Student) super.clone();
        return student;
    }

    @Override
    public String toString() {
        return "Student{" +
                "address=" + address +
                ", number=" + number +
                '}';
    }
}
