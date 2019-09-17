package com.wander.core.utils;

/**
 * 加密工具类
 * 珂铭加密工具
 */
public class KemingCodeUtil {

    /**
     * 加密
     *
     * @param msg       原文
     * @param secretKey 密钥
     * @return 密文
     */
    public static String encode(String msg, String secretKey) {
        char[] msgArr = msg.toCharArray();
        char[] keyArr = secretKey.toCharArray();
        String[] resArr = new String[msgArr.length];
        int t = 0;
        for (int i = 0; i < msgArr.length; i++) {
            resArr[i] = trans(msgArr[i], keyArr[t]);
            if (++t >= keyArr.length)
                t = 0;
        }
        StringBuffer strb = new StringBuffer();
        for (String s : resArr) {
            strb.append(s);
        }
        return strb.toString();
    }

    /**
     * 解密
     *
     * @param code      密文
     * @param secretKey 密钥
     * @return 原文
     */
    public static String decode(String code, String secretKey) {
        String[] codeArr = code.split("_");
        char[] keyArr = secretKey.toCharArray();
        char[] resArr = new char[codeArr.length];
        int t = 0;
        for (int i = 0; i < codeArr.length; i++) {
            resArr[i] = deTrans(codeArr[i], keyArr[t]);
            if (++t >= keyArr.length)
                t = 0;
        }
        StringBuffer strb = new StringBuffer();
        for (char c : resArr) {
            strb.append(c);
        }
        return strb.toString();
    }

    private static String trans(char msg, char key) {
        return msg + key + "_";
    }

    private static char deTrans(String code, char key) {
        return (char) (Integer.parseInt(code) - key);
    }

}
