package org.springboot.demo.encrypt.codec;


import com.sun.istack.internal.Nullable;
import lombok.NonNull;

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
