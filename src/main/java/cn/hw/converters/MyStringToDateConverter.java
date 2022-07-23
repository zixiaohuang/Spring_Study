package cn.hw.converters;


import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * 1。定义类型转换器 需要明确 原类型 目标类型
 * 2。在converter自定义类型转换的实现
 * 3。在spring-mvc中配置自定类型转换器
 * 4。annotation-driven
 */
public class MyStringToDateConverter implements Converter<String, Date> {

    @Override
    public Date convert(String source) {
        if(!StringUtils.isEmpty(source)) {
            try {
                if(source.split("-").length == 3) {
                    DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                    return df.parse(source);
                }else if(source.split("/").length == 3) {
                    DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
                    return df.parse(source);
                }else {
                    throw new RuntimeException("日期转换错误"+source);
                }
            } catch (ParseException e){
                e.printStackTrace();
            }
        }
        return null;
    }
}
