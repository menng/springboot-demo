package org.springboot.demo.encrypt.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springboot.demo.encrypt.codec.DefaultSecurityCodecHandler;
import org.springboot.demo.encrypt.codec.SecurityCodecHandlerFactory;
import org.springboot.demo.encrypt.support.RequestDecryptBodyArgumentResolver;
import org.springboot.demo.encrypt.support.ResponseEncryptBodyMessageConverter;
import org.springboot.demo.encrypt.support.ResponseEncryptBodyMethodProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

/**
 * 自定义注解添加Spring注解解析器集合中
 * @author menng
 */
@Configuration
public class HttpConverterConfig extends WebMvcConfigurerAdapter {

    @Autowired
    private RequestDecryptBodyArgumentResolver requestDecryptBodyArgumentResolver;
    @Autowired
    private ResponseEncryptBodyMessageConverter responseEncryptBodyMessageConverter;

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(requestDecryptBodyArgumentResolver);
    }

    @Bean
    @ConditionalOnMissingBean(RequestDecryptBodyArgumentResolver.class)
    public RequestDecryptBodyArgumentResolver requestDecryptBodyArgumentResolver(
            SecurityCodecHandlerFactory securityCodecHandlerFactory) {
        return new RequestDecryptBodyArgumentResolver(securityCodecHandlerFactory);
    }

    @Bean
    @ConditionalOnMissingBean(SecurityCodecHandlerFactory.class)
    public SecurityCodecHandlerFactory securityCodecHandlerFactory() {
        return new SecurityCodecHandlerFactory(new DefaultSecurityCodecHandler());
    }

    @Bean
    @ConditionalOnMissingBean(ResponseEncryptBodyMessageConverter.class)
    public ResponseEncryptBodyMessageConverter responseEncryptBodyMessageConverter(@Autowired ObjectMapper objectMapper) {
        return new ResponseEncryptBodyMessageConverter(objectMapper);
    }

    @Bean
    @ConditionalOnMissingBean(ResponseEncryptBodyMethodProcessor.class)
    public ResponseEncryptBodyMethodProcessor responseEncryptBodyMethodProcessor(@Autowired List<HttpMessageConverter<?>> converters) {
        converters.add(responseEncryptBodyMessageConverter);
        List<HttpMessageConverter<?>> list = converters;
        return new ResponseEncryptBodyMethodProcessor(list);
    }
}
