package org.springboot.demo.encrypt.support;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import lombok.extern.slf4j.Slf4j;
import org.springboot.demo.encrypt.annotation.RequestDecryptBody;
import org.springboot.demo.encrypt.codec.SecurityCodecHandler;
import org.springboot.demo.encrypt.codec.SecurityCodecHandlerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;

/**
 * RequestDecryptBody注解解析器
 * @author menng
 * @see HandlerMethodArgumentResolver
 * @see RequestDecryptBody
 */
@Slf4j
public class RequestDecryptBodyArgumentResolver implements HandlerMethodArgumentResolver {

    private final SecurityCodecHandlerFactory securityCodecHandlerFactory;

    protected ObjectMapper objectMapper = new ObjectMapper();

    public RequestDecryptBodyArgumentResolver(SecurityCodecHandlerFactory securityCodecHandlerFactory) {
        this.securityCodecHandlerFactory = securityCodecHandlerFactory;
    }

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.hasParameterAnnotation(RequestDecryptBody.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer modelAndViewContainer,
                                  NativeWebRequest webRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {
        HttpServletRequest request = webRequest.getNativeRequest(HttpServletRequest.class);
        RequestDecryptBody requestDecryptBody = parameter.getParameterAnnotation(RequestDecryptBody.class);
        String content = webRequest.getParameter(requestDecryptBody.content());

        // 解密
        SecurityCodecHandler securityCodecHandler = securityCodecHandlerFactory.getSecurityCodecHandler();
        String decryptContent = securityCodecHandler.decrypt(content, request);

        objectMapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
        return objectMapper.readValue(decryptContent, parameter.getParameterType());
    }
}