package other.link;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.util.Arrays;

public class Base64Util {
    /***
     * BASE64解密
     * @param key
     * @return
     * @throws Exception
     */
    public static byte[] decryBASE64(String key) throws Exception{
        return (new BASE64Decoder()).decodeBuffer(key);
    }

    /***
     * BASE64加密
     * @param key
     * @return
     * @throws Exception
     */
    public static String encryptBASE64(byte[] key) throws Exception{
        return (new BASE64Encoder()).encode(key);
    }

    public static void main(String[] args) throws Exception{
        String key="hello world";
        String encry = encryptBASE64(key.getBytes());
        System.out.println(encry);
        byte[] decry = decryBASE64(encry);
        String value = new String(decry, "utf-8");
        System.out.println(value);

    }
}
