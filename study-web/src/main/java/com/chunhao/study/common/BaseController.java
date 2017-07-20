package com.chunhao.study.common;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.chunhao.study.result.base.Result;
import com.chunhao.study.util.base.DateTimeUtil;
import com.chunhao.study.util.base.IgnorePropertyPreFilter;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by count on 17/3/17.
 */
public class BaseController
{
    /**
     * 忽略 null 值
     * @param result
     * @param response
     */
    protected void printJson(Result result, HttpServletResponse response)
    {

        JSON.DEFFAULT_DATE_FORMAT = DateTimeUtil.TIME_FORMAT_STRING_A;

        //SerializerFeature.DisableCircularReferenceDetect 是为了解决对象循环引用的问题
        // 如果不加，则返回的result里存在两个同样的对象，则返回给前端第二个相同对象使用ref指向地址的，不是直接将对象输出
        String json = JSON.toJSONString(result, SerializerFeature.WriteDateUseDateFormat, SerializerFeature.DisableCircularReferenceDetect);

        printJson(json, response);

    }

    /**
     * 忽略属性输出
     *
     * @param result
     * @param ignoreProperties 忽略的属性
     * @param response
     */
    protected void printJson(Result result, String[] ignoreProperties, HttpServletResponse response)
    {
        JSON.DEFFAULT_DATE_FORMAT = DateTimeUtil.TIME_FORMAT_STRING_A;

        //SerializerFeature.DisableCircularReferenceDetect 是为了解决对象循环引用的问题
        // 如果不加，则返回的result里存在两个同样的对象，则返回给前端第二个相同对象使用ref指向地址的，不是直接将对象输出
        String json = JSON.toJSONString(result, new IgnorePropertyPreFilter(ignoreProperties), SerializerFeature.WriteDateUseDateFormat, SerializerFeature.DisableCircularReferenceDetect);

        printJson(json, response);
    }

    /**
     * 向客户端返回指定 json 字符串
     * @param json
     * @param response
     */
    protected void printJson(String json, HttpServletResponse response)
    {
        if (null == response)
        {
            return;
        }

        try
        {
            response.reset();
            response.setContentType("application/json; charset=UTF-8");

            if (StringUtils.isEmpty(json))
            {
                response.getWriter().write("{}");
            }
            else
            {
                response.getWriter().write(json);
            }
        } catch (IOException e)
        {
            e.printStackTrace();
        }

    }

    @InitBinder
    protected void initBinder(WebDataBinder webDataBinder)
    {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        simpleDateFormat.setLenient(false);

        webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(simpleDateFormat, true));
    }

}
