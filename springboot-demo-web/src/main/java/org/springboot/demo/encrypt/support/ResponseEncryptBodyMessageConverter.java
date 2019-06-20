package org.springboot.demo.encrypt.support;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springboot.demo.encrypt.annotation.ResponseEncryptBody;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.http.converter.json.AbstractJackson2HttpMessageConverter;
import org.springframework.web.servlet.mvc.method.annotation.RequestResponseBodyMethodProcessor;

import java.io.IOException;
import java.lang.reflect.Type;

/**
 * @author menng
 * @see RequestResponseBodyMethodProcessor
 * @see ResponseEncryptBody
 */
@Slf4j
public class ResponseEncryptBodyMessageConverter extends AbstractJackson2HttpMessageConverter {

    public ResponseEncryptBodyMessageConverter(ObjectMapper objectMapper) {
        super(objectMapper);
    }

    @Override
    protected void writeInternal(Object object, Type type, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
        super.writeInternal(object, type, outputMessage);
    }
}
