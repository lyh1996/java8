package crypto;

import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.digest.DigestUtil;

/**
 * @author 633805 LYH
 * @version V1.0
 * @description 摘要加密测试   单向散列加密
 * @create 2019-07-18 15:40
 * @since 1.7
 */
public class DigestTest {

    public static void main(String[] args) {

        // 加密内容
        String name = "单向散列加密";

        String pwdValue = DigestUtil.bcrypt(name);

        System.out.println(pwdValue);
        // 验证密码是否和密文一样
        System.out.println("是否一样  true表示一样" + DigestUtil.bcryptCheck(name, pwdValue));
        System.out.printf("32MD5加密后:%s  \n",DigestUtil.md5Hex(name));

        System.out.printf("32MD5加密后:%s  \n", SecureUtil.md5(name));


        System.out.printf("SHA-1加密后:%s  \n",DigestUtil.sha1Hex(name));
        System.out.printf("SHA-256加密后:%s  \n",DigestUtil.sha256Hex(name));


        System.out.printf("16MD5加密后:%s",DigestUtil.md5HexTo16(  DigestUtil.md5Hex(name)   ));

    }
}
