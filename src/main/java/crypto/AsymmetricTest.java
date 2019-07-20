package crypto;

import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.asymmetric.AsymmetricAlgorithm;
import cn.hutool.crypto.asymmetric.KeyType;

import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;

/**
 * @author 633805 LYH
 * @version V1.0
 * @description 非对称加密测试
 * @create 2019-07-18 15:39
 * @since 1.7
 */
public class AsymmetricTest {
    public static void main(String[] args) {

        // 加密字段
        String name = "非对称加密测试";

        //
        KeyPair keyPair = SecureUtil.generateKeyPair(AsymmetricAlgorithm.RSA.getValue());

        //获取公钥
        PublicKey publicKey = keyPair.getPublic();

        //公钥加密
        String enValue = SecureUtil.rsa(null, publicKey.getEncoded()).encryptHex(name, KeyType.PublicKey);
        // 获取私钥
        PrivateKey privateKey = keyPair.getPrivate();

        // 私钥解密

        String deValue = SecureUtil.rsa(privateKey.getEncoded(), null).decryptStr(enValue, KeyType.PrivateKey);


        System.out.println("加密后内容:" + enValue);
        System.out.println("解密后内容:" + deValue);

    }
}
