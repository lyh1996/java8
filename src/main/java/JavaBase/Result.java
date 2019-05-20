package JavaBase;

import java.io.Serializable;

/**
 * @author 633805 LYH
 * @version V1.0
 * @description 对类的描述
 * @create 2019-03-01 11:53
 * @since 1.7
 */
public class Result<T> implements Serializable {
    private static final long serialVersionUID = -5507197647413665254L;
    private boolean ok;
    private String errorCode;
    private String errorMsg;
    private T data;

    public Result() {
    }

    public static Result<Void> ok() {
        Result result = new Result();
        result.setOk(true);
        return result;
    }

    public static <T> Result<T> ok(T data) {
        Result<T> result = new Result();
        result.setOk(true);
        result.setData(data);
        return result;
    }

    public static Result<Void> failed(String errorMsg) {
        Result<Void> result = new Result();
        result.setOk(false);
        result.setErrorMsg(errorMsg);
        return result;
    }

    public static Result<Void> failed(String errorCode, String errorMsg) {
        Result<Void> result = new Result();
        result.setOk(false);
        result.setErrorCode(errorCode);
        result.setErrorMsg(errorMsg);
        return result;
    }

    public String getErrorCode() {
        return this.errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean getOk() {
        return this.ok;
    }

    public boolean isOk() {
        return this.ok;
    }

    public void setOk(boolean ok) {
        this.ok = ok;
    }
}
