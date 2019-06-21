package org.springboot.demo.encrypt.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springboot.demo.encrypt.codec.DefaultSecurityCodecHandler;
import org.springboot.demo.encrypt.codec.SecurityCodecHandlerFactory;
import org.springboot.demo.encrypt.support.RequestDecryptBodyArgumentResolver;
import org.springboot.demo.encrypt.support.ResponseEncryptBodyMessageConverter;
import org.springboot.demo.encrypt.support.ResponseEncryptBodyMethodProcessor;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author menng
 */
@Slf4j
@Configuration
public class MessageConverterConfig implements WebMvcConfigurer {

    @Autowired
    private RequestDecryptBodyArgumentResolver requestDecryptBodyArgumentResolver;

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
        return new ResponseEncryptBodyMethodProcessor(converters);
    }

    @Configuration
    public static class ResponseEncryptBodyBeanPostProcessor implements BeanPostProcessor {

        @Autowired
        private ResponseEncryptBodyMethodProcessor responseEncryptBodyMethodProcessor;

        @Override
        public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
            return  o;
        }

        /**
         * bean 加载完毕后执行
         */
        @Override
        public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
            if (beanName.equalsIgnoreCase("requestMappingHandlerAdapter")) {
                RequestMappingHandlerAdapter requestMappingHandlerAdapter = (RequestMappingHandlerAdapter) bean;
                List<HandlerMethodReturnValueHandler> returnValueHandlers = requestMappingHandlerAdapter.getReturnValueHandlers();
                for (HandlerMethodReturnValueHandler r: returnValueHandlers) {
                    log.info("{}", r.getClass().getName());
                }
                if (returnValueHandlers == null) {
                    return bean;
                }
                List<HandlerMethodReturnValueHandler> modifiedReturnValueHandlers = new ArrayList<>(returnValueHandlers);
                modifiedReturnValueHandlers.add(0, responseEncryptBodyMethodProcessor);
                // 在原有的bean上先清空再添加
                ((RequestMappingHandlerAdapter) bean).setReturnValueHandlers(null);
                ((RequestMappingHandlerAdapter) bean).setReturnValueHandlers(modifiedReturnValueHandlers);
            }
            return bean;
        }
    }

}
