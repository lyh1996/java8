package JavaBase;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.CircleCaptcha;

import java.time.LocalDate;

/**
 * @author 633805 LYH
 * @version V1.0
 * @description 对类的描述
 * @create 2019-07-09 16:46
 * @since 1.7
 */
public class CaptchaUtilTest {
    public static void main(String[] args) {

        CircleCaptcha lineCaptcha = CaptchaUtil.createCircleCaptcha(300,200);

        String path = "D://a/" + LocalDate.now() + ".png";
        System.out.println(lineCaptcha.getCode() + " >" + path);
        lineCaptcha.write(path);
    }
}
