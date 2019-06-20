package org.springboot.demo.encrypt.support;

import lombok.extern.slf4j.Slf4j;
import org.springboot.demo.encrypt.annotation.ResponseEncryptBody;
import org.springframework.core.MethodParameter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.servlet.mvc.method.annotation.RequestResponseBodyMethodProcessor;

import java.io.IOException;
import java.util.List;

/**
 * @author menng
 * @see RequestResponseBodyMethodProcessor
 * @see ResponseEncryptBody
 */
@Slf4j
public class ResponseEncryptBodyMethodProcessor extends RequestResponseBodyMethodProcessor {

    public ResponseEncryptBodyMethodProcessor(List<HttpMessageConverter<?>> converters) {
        super(converters);
    }

    @Override
    public boolean supportsReturnType(MethodParameter returnType) {
        return returnType.hasMethodAnnotation(ResponseEncryptBody.class);
    }

    @Override
    public void handleReturnValue(Object returnValue, MethodParameter returnType, ModelAndViewContainer mavContainer, NativeWebRequest webRequest) throws IOException, HttpMediaTypeNotAcceptableException, HttpMessageNotWritableException {
        super.handleReturnValue(returnValue, returnType, mavContainer, webRequest);
    }
}
