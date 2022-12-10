package org.example;

/**
 * 十六进制（Hex）由0-9，A-F组成，字母不区分大小写
 * 字节（Byte）
 * 转换原理：
 * ∵ 一个bit有两种状态：0、1
 *   两个bit有四种状态：00、01、10、11
 *   三个bit有8种状态：000、001、010、100、011、101、110、111
 *   四个bit有16种状态：0000、0001、0010、0100、1000、...1111
 * ∴ 4个bit可以用来表示一个16进制（Hex）的数
 * ∴ 一个字节（Byte）可以表示两个16进制（Hex）的数
 */
public class HexByteUtil {

    /**
     * Byte转Hex
     * @param b 字节
     * @return 十六进制字符串
     */
    public static String byteToHex(byte b) {
        String hex = Integer.toHexString(b & 0xFF);
        if (hex.length() < 2) {
            hex = hex.concat("0");
        }
        return hex;
    }

    /**
     * Byte数组转Hex
     * @param bytes 字节数组
     * @return 十六进制字符串
     */
    public static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte aByte : bytes) {
            sb.append(byteToHex(aByte));
        }
        return sb.toString();
    }

    /**
     * Hex字符串转byte
     * @param hex 0x00~0xFF的字符串
     * @return 字节
     */
    public static byte hexToByte(String hex) {
        return (byte) Integer.parseInt(hex, 16);
    }

    /**
     * hex字符串转byte数组
     * @param hex 十六进制字符串
     * @return 字节数组
     */
    public static byte[] hexToBytes(String hex) {
        int hexLen = hex.length();
        byte[] bytes;
        // 根据字符串长度在前面补0
        if ((hexLen & 1) == 1) {
            // 奇数
            hexLen++;
            bytes = new byte[(hexLen / 2)];
            hex = "0" + hex;
        } else {
            bytes = new byte[(hexLen / 2)];
        }
        // 两个字符代表一个十六进制数
        for (int i = 0, j = 0; i < hexLen; i += 2) {
            bytes[j] = hexToByte(hex.substring(i, i + 2));
            j++;
        }
        return bytes;
    }
}
