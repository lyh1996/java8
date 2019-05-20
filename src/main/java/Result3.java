import java.io.Serializable;

/**
 * @author 633805 LYH
 * @version V1.0
 * @description 对类的描述
 * @create 2019-05-14 17:33
 * @since 1.7
 */
public class Result3<T> implements Serializable {

    private static final long serialVersionUID = 5322970880468817443L;
    private String statusCode;
    private String errMsg;
    private T result;

    public Result3() {
    }

    public String getStatusCode() {
        return this.statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getErrMsg() {
        return this.errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public T getResult() {
        return this.result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "Result3{" +
                "statusCode='" + statusCode + '\'' +
                ", errMsg='" + errMsg + '\'' +
                ", result=" + result +
                '}';
    }
}
