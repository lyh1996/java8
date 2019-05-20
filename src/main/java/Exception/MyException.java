package Exception;

/**
 * @author 633805 LYH
 * @version V1.0
 * @description 对类的描述
 * @create 2019-04-24 8:15
 * @since 1.7
 */
public final class MyException extends RuntimeException {
    private static final long serialVersionUID = 5914176938884188643L;
    private String code;

    public MyException() {
    }

    public MyException(String message) {
        super(message);
    }

    public MyException(String code, String message) {
        super(message);
        this.code = code;
    }

    public MyException(String message, Throwable cause) {
        super(message, cause);
    }

    public MyException(String code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

    public String getCode() {
        return this.code;
    }
}
