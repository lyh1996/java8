package JavaBase;

/**
 * @author 633805 LYH
 * @version V1.0
 * @description 对类的描述
 * @create 2019-05-14 17:25
 * @since 1.7
 */

public class Result2 extends Result3 {

    private String  abc;

    public String getAbc() {
        return abc;
    }

    public void setAbc(String abc) {
        this.abc = abc;
    }

    @Override
    public String toString() {
        return "Result2{" +
                "abc='" + abc + '\'' +
                '}';
    }
}
