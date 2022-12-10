package hexbytestring;

import org.example.HexByteUtil;

public class HexByteStringTest {

    public static void main(String[] args) {
        // 字符串转16进制字符串
        String character = "TEST";
        System.out.println(HexByteUtil.bytesToHex(character.getBytes()));
    }
}
