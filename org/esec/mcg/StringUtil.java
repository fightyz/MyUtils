package org.esec.mcg.utils;

import java.util.Map;

/**
 * Created by yz on 2015/10/8.
 * 以String或String数组为操作对象的工具类
 */
public final class StringUtil {

    /**
     * hex string to a byte array
     * "FF001020FH" -> {(byte)0xff, 0x00, 0x10, 0x02, (byte)0xfh}
     * @param hex
     * @return
     */
    public static byte[] HexStringToByteArray(String hex) {
        String tmp = hex.replaceAll("[^[0-9][a-f]]", "");
        byte[] bytes = new byte[tmp.length() / 2];

        String part = "";

        for(int i = 0; i <bytes.length; i++) {
            part = "0x" + tmp.substring(i * 2, i * 2 + 2);
            bytes[i] = Integer.decode(part).byteValue();
        }

        return bytes;
    }
}
