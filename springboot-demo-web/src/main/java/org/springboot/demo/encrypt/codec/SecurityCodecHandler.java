package org.springboot.demo.encrypt.codec;

import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import javax.servlet.http.HttpServletRequest;

public interface SecurityCodecHandler {

    /**
     * 解密
     * @param content 解密参数内容
     * @param request 请求request
     * @return 解密后的参数，一般为json
     */
    String decrypt(@NonNull String content, @Nullable HttpServletRequest request);

    /**
     * 加密
     * @param content 加密内容
     * @param object  返回原始对象
     * @return 加密后的参数
     */
    String encrypt(@NonNull String content, @Nullable Object object);
}
