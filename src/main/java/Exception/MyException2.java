package Exception;

/**
 * @author 633805 LYH
 * @version V1.0
 * @description 对类的描述
 * @create 2019-04-24 8:15
 * @since 1.7
 */
public final class MyException2 extends RuntimeException {
    private static final long serialVersionUID = 5914176938884188643L;
    private String code;

    public MyException2() {
    }

    public MyException2(String message) {
        super(message);
    }

    public MyException2(String code, String message) {
        super(message);
        this.code = code;
    }

    public MyException2(String message, Throwable cause) {
        super(message, cause);
    }

    public MyException2(String code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

    public String getCode() {
        return this.code;
    }
}
