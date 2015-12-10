package org.esec.mcg.utils;

import java.util.Map;
import java.util.Set;
import java.util.HashSet;
import java.lang.StringBuilder;
import java.lang.String;

/**
 * Created by yz on 2015/10/8.
 * 以String或String数组为操作对象的工具类
 */
@SuppressWarnings("unchecked")
public final class StringUtil {

    public static final Set set = new HashSet() {{
        add('8');
        add('9');
        add('a');
        add('A');
        add('b');
        add('B');
        add('b');
        add('C');
        add('c');
        add('D');
        add('d');
        add('E');
        add('e');
        add('F');
        add('f');
    }};

    /**
     * hex string to a byte array
     * "FF001020FH" -> {(byte)0xff, 0x00, 0x10, 0x02, (byte)0xfh}
     * @param hex
     * @return
     */
    public static byte[] HexStringToByteArray(String hex) {
        String tmp = hex.replaceAll("[^0-9a-fA-F]", ""); // 先将不合法字符全部替换掉
        byte[] bytes = new byte[tmp.length() / 2];

        String part = "";

        for(int i = 0; i <bytes.length; i++) {
            part = "0x" + tmp.substring(i * 2, i * 2 + 2);
            bytes[i] = Integer.decode(part).byteValue();
        }

        return bytes;
    }

    /**
     * hex string to hard code byte array string
     * 1. 不带空格的十六机制字符串：
     *    "FF001020FH" -> "(byte)0xff, 0x00, 0x10, 0x02, (byte)0xfh"
     * 2. 带空格的十六进制字符串：
     *    "FF 00 10 20 FH" -> "(byte)0xff, 0x00, 0x10, 0x02, (byte)0xfh"
     */
    public static String HexStringToHardCodeByteArrayString(String buffer) {
        String tmp = buffer.replaceAll("[^0-9a-fA-F]", ""); // 先将不合法字符全部替换掉
        StringBuilder sb = new StringBuilder();
        int len = tmp.length();

        for (int i = 0; i < len; i++) {
            char c = tmp.charAt(i);

            if (i % 2 == 0 ) {
                if (set.contains(c)) {
                    sb.append("(byte)0x");
                    sb.append(c);
                } else {
                    sb.append("0x");
                    sb.append(c);
                }
            } else {
                sb.append(c);
                sb.append(", ");
            }
        }

        sb.delete(sb.length() - 2, sb.length());

        return sb.toString();
    }
}
