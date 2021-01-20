package com.hazer;


import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;
import sun.misc.BASE64Decoder;


import javax.crypto.Cipher;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.Security;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @description: </br>
 * @author: Hazer
 * @date: 2020-06-23 10:16
 */
public class TestMain {
    public static void main(String[] args) throws Exception {
        String privateKey = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBALZjydq9lPHQwR7eK64ozcD8QdJQ5IGMHECu3hRK422j3FInLLVP8C9wXoDZaSa+bjsJJGqd6RII6xpQxKAfiSg/qZwBPNJmTRVwRA5zaPQBWo5mjEtccfox+ooIGQ6LX5j3B+LY//0BF2GJybNa1AoZB8r56srRAJalg6LG7woJAgMBAAECgYBag7NNRwB/8WWl+AQdbkqOF6JiyZpdYDc1MpMr5u5vHv7cFmztnjpIkK+Vqk+w1pjF24ejEbL1LE/gw2yROpVJ+bHj8VdYnz45v8Q/DuyFirx6kNR24a/2dJBc8J92diK0ywrwwKLU8t3JGTjYkeZt7cBaNgW3fxSAbkKddZuZwQJBANpXCYEuq0CGwd5Ami9MQuIOZRtEf0R+JZ/aTv6A9omp9wuLrgf062ZvQwhyKdbyts5XAE1WlZCO9hAEAr7ey3UCQQDV2VgiVOocPnaYzGWp76JMhlWVFm6RXZXhkgj4LhfGEZtjiZa8jNXNQx4KcP51T43Bxz2Ky/R7Yfu9vj/4gHXFAkA/O53BD+cA1QYoe8UrlYZ5OXoGn5vMFkyHMw5VnrvHurWVXmqUW1YhYG+lboq3eat/rqqju0OtjfmtQbwZ0yRRAkB7ZDCVhrea2nPmELJsjqfwTebd4paj7AMKqA/i2/29vPUTRxWh8AWBrcOMtMwudlvOPx+EkdCczNnMDxWsVrsdAkEA1M9zDd+1xg0qmoMjr4BRNdKJAk2SCrgS7FmPC3ejWaJf3IJB5AlOLocTpitaVVQG8OrZnCX3P+BvyTtZJu1OKA==";
        String appId = "dd7eda52-d1f9-4fa2-ae46-a8b3a4410d91";
//        String version = "v1.0";
//        String timeStamp = String.valueOf(System.currentTimeMillis());
//        System.out.println(timeStamp);
//        String sign = version + appId + "1596698508058";
//        String signMd5 = DigestUtils.md5Hex(sign);
//        String sign2 = RSAUtil.encryptByPrivateKey(signMd5, privateKey);
//        System.out.println("生成的签名是：" + sign2);
        String sign = "Vjgg/P3m6gsNtKQL422ZMAhsHhXn/TuGtkDLcXwKR5e2HRN+3gsJrHiH0+0NgtP7R17q5MxOv1m6xVQCSh4BHE9MEjkDl5PDew8TmWUYh1JgqqQbnBbHv2ey4XFLq5CZ+7+IfMTi7znt7ufWZ5h7gC9Ed8s9Sz4O2LrE/TSsDKM=";
        String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC2Y8navZTx0MEe3iuuKM3A/EHSUOSBjBxArt4USuNto9xSJyy1T/AvcF6A2Wkmvm47CSRqnekSCOsaUMSgH4koP6mcATzSZk0VcEQOc2j0AVqOZoxLXHH6MfqKCBkOi1+Y9wfi2P/9ARdhicmzWtQKGQfK+erK0QCWpYOixu8KCQIDAQAB";
        RSAUtil.decryptByPublicKey(sign, publicKey);
    }

    public static String decrypt(byte[] text, PublicKey key) {
        byte[] dectyptedText = null;
        try {
            //秘钥初始化时加入制定默认的算法库
            Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
            //使用第三方算法加密库 BC
            final Cipher cipher = Cipher.getInstance("RSA/None/PKCS1Padding");
            cipher.init(Cipher.DECRYPT_MODE, key);
            //分段
            int inputLen = text.length;
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            int offSet = 0;
            byte[] cache;
            int i = 0;
            // 对数据分段解密
            while (inputLen - offSet > 0) {
                if (inputLen - offSet > 128) {
                    cache = cipher.doFinal(text, offSet, 128);
                } else {
                    cache = cipher.doFinal(text, offSet, inputLen - offSet);
                }
                out.write(cache, 0, cache.length);
                i++;
                offSet = i * 128;
            }
            dectyptedText = out.toByteArray();
            out.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return new String(dectyptedText);
    }


    public static PublicKey getPublicKey(String key) throws Exception {
        byte[] keyBytes;
        keyBytes = (new BASE64Decoder()).decodeBuffer(key);
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PublicKey publicKey = keyFactory.generatePublic(keySpec);
        return publicKey;
    }


    public static String str2HexStr(String str, String charset) throws UnsupportedEncodingException {
        return Hex.encodeHexString(str.getBytes(charset));
    }
}
