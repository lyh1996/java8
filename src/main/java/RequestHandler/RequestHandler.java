package RequestHandler;

/**
 * @author 633805 LYH
 * @version V1.0
 * @description 对类的描述
 * @create 2019-08-09 16:52
 * @since 1.7
 */
public class RequestHandler {
    public String handle(String request) {
        return "From NIOServer Hello " + request + ".\n";
    }
}
