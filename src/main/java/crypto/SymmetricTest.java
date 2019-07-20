package crypto;

import cn.hutool.crypto.SecureUtil;

import javax.crypto.SecretKey;

/**
 * @author 633805 LYH
 * @version V1.0
 * @description 对称加密测试
 * @create 2019-07-18 15:41
 * @since 1.7
 */
public class SymmetricTest {

    public static void main(String[] args) {
        String name = "对称加密测试";


        // 生成密钥
        SecretKey secretKey =  SecureUtil.generateKey("DES");

        String pwdValue = SecureUtil.des(secretKey.getEncoded()).encryptBase64(name);
        String pwdValue2 = SecureUtil.des(secretKey.getEncoded()).encryptHex(name);

        System.out.println("加密后的内容为(Base64):" + pwdValue);
        System.out.println("加密后的内容为(HEX):" + pwdValue2);

        String decryptValue = SecureUtil.des(secretKey.getEncoded()).decryptStr(pwdValue);
        String decryptValue2 = SecureUtil.des(secretKey.getEncoded()).decryptStr(pwdValue2);

        System.out.println("解密后的内容为(Base64):" + decryptValue);
        System.out.println("解密后的内容为(HEX):" + decryptValue2);
    }
}
