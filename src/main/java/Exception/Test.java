package Exception;

import lombok.extern.slf4j.Slf4j;

/**
 * @author 633805 LYH
 * @version V1.0
 * @description 对类的描述
 * @create 2019-04-24 8:16
 * @since 1.7
 */
@Slf4j
public class Test {
    public static void main(String[] args) {
        int count = 0;
        try {
            Method1();

        }catch (MyException e) {
            count++;
            System.out.println("进入自定义异常");
            System.out.println(e.getMessage());
        }catch (MyException2 e) {
            count++;
            System.out.println("123");
        }catch (Exception e) {
            count++;
            System.out.println("Exception异常");
        }
        System.out.println(count);
    }
    public static void Method1() {
        try{
            int i = 10/0;
        } catch (Exception e){
            log.error("方法出现异常[{}]", e.toString(), e);
            System.out.println("进入异常方法");
            throw new MyException();
        }

    }

}
