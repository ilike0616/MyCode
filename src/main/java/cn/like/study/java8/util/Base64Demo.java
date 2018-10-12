package cn.like.study.java8.util;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * @program: MyCode
 * @description: 在Java 8中，Base64编码已经成为Java类库的标准.
 * Base64类同时还提供了对URL、MIME友好的编码器与解码器
 * （Base64.getUrlEncoder() / Base64.getUrlDecoder(),
 * Base64.getMimeEncoder() / Base64.getMimeDecoder()）。
 * @author: like
 * @create: 2018-05-05 17:37
 **/
public class Base64Demo {
    public static void main(String[] args) {
        final String text = "ZXN,I love you!";

        final String encode = Base64.getEncoder().encodeToString(text.getBytes(StandardCharsets.UTF_8));
        System.out.println(encode);

        final String decode = new String(Base64.getDecoder().decode(encode), StandardCharsets.UTF_8);
        System.out.println(decode);
    }
}
