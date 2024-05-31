package org.mild.common.web.config;

import com.alibaba.fastjson2.JSONReader;
import com.alibaba.fastjson2.JSONWriter;
import com.alibaba.fastjson2.support.config.FastJsonConfig;
import com.alibaba.fastjson2.support.spring6.http.converter.FastJsonHttpMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * @author 史偕成
 * @title LocaleConfigBaseVO
 * @description json 配置
 * @create 2023/11/28 9:23
 */
@Configuration
public class JSONWebConfigurer implements WebMvcConfigurer {

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setCharset(StandardCharsets.UTF_8);
        fastJsonConfig.setReaderFeatures(
                //字段如 vBtn  会被转为 VBtn  处理这样的问题
                JSONReader.Feature.SupportSmartMatch,
                JSONReader.Feature.FieldBased,
                //初始化String字段为空字符串""
                JSONReader.Feature.InitStringFieldAsEmpty,
                //对读取到的字符串值做trim处理
                JSONReader.Feature.TrimString);
        fastJsonConfig.setWriterFeatures(
                //字段如 vBtn  会被转为 VBtn  处理这样的问题
                JSONWriter.Feature.FieldBased,
                //long 转 string 丢失精度问题
                JSONWriter.Feature.WriteLongAsString,
                // 保留map空的字段
                JSONWriter.Feature.WriteMapNullValue,
                //将List类型的null转成[]
                JSONWriter.Feature.WriteNullListAsEmpty,
                //将String类型的null转成""
                JSONWriter.Feature.WriteNullStringAsEmpty,
                //将Boolean类型的null转成false
                JSONWriter.Feature.WriteNullBooleanAsFalse,
                //日期格式转换
                JSONWriter.Feature.PrettyFormat,
                //将空置输出为缺省值，Number类型的null都输出为0，String类型的null输出为""，数组和Collection类型的输出为[]
                JSONWriter.Feature.NullAsDefaultValue);
        fastJsonHttpMessageConverter.setFastJsonConfig(fastJsonConfig);
        converters.add(0, fastJsonHttpMessageConverter);
    }
}
