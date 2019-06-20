package org.springboot.demo.encrypt.codec;


import lombok.NonNull;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author menng
 */
@Component
public class DefaultSecurityCodecHandler implements SecurityCodecHandler {

    @Override
    public String decrypt(@NonNull String content, HttpServletRequest request) {
        return "{\"id\":1,\"request_address\":\"request.test\"}";
    }

    @Override
    public String encrypt(@NonNull String content, Object object) {
        return null;
    }
}
