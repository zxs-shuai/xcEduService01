package com.xuecheng.framework.exception;

import com.google.common.collect.ImmutableMap;
import com.xuecheng.framework.model.response.CommonCode;
import com.xuecheng.framework.model.response.ResponseResult;
import com.xuecheng.framework.model.response.ResultCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.expression.spel.ast.NullLiteral;
import org.springframework.http.converter.HttpMessageConversionException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 统一异常捕获类
 */

@ControllerAdvice //控制器增强
public class ExceptionCatch {
    private static final Logger LOGGER =  LoggerFactory.getLogger(ExceptionCatch.class);

    //定义一个Map,配置异常类型所对应的异常编码
    private static ImmutableMap<Class<? extends Throwable>,ResultCode> EXCEPTIONS;
    //定义Map的builder对象，去构建ImmutableMap
    private static ImmutableMap.Builder<Class<? extends Throwable>,ResultCode> builder = new ImmutableMap.Builder();



    @ExceptionHandler(CustomException.class)
    @ResponseBody
    public ResponseResult customException(CustomException customException){
        //记录日志
        LOGGER.error("catch exception:{}", customException.getMessage());
        ResultCode resultCode = customException.getResultCode();
        return  new ResponseResult(resultCode);

    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseResult exception(Exception exception){
        //记录日志
        LOGGER.error("catch exception:{}",exception.getMessage());
        if (EXCEPTIONS ==null){
            EXCEPTIONS=builder.build();  //EXECPTIONS构建成功
        }
        //从EXCEPTIONS中找异常类型所对应的错误代码，如果找到了将错误代码响应给用户，如果找不到给用户相应999999异常
        ResultCode resultCode = EXCEPTIONS.get(exception.getClass());
        if (resultCode !=null){
            return  new ResponseResult(resultCode);
        }
        else{
            //返回99999异常
            return  new ResponseResult(CommonCode.SERVER_ERROR);
        }


    }

    static {
        //定义了异常类型所对应的代码
        builder.put(HttpMessageConversionException.class,CommonCode.INVALID_PATH);

    }

}
