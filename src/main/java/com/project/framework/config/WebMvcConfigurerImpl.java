package com.project.framework.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.project.security.interceptor.ReqInterceptor;

@Configuration
public class WebMvcConfigurerImpl implements WebMvcConfigurer{
	@Autowired
	private ReqInterceptor reqInterceptor;
	
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
        converter.setFeatures(SerializerFeature.WriteNullListAsEmpty,
                SerializerFeature.WriteMapNullValue,
                SerializerFeature.WriteNullStringAsEmpty,//字符串null返回空字符串
                SerializerFeature.WriteNullBooleanAsFalse,
                SerializerFeature.PrettyFormat);
        converters.add(converter);
   }
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(reqInterceptor).addPathPatterns("/safety/accountNumber/**");
    }

}
