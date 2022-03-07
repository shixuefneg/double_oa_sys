package com.dou.servicerely.handler;


import com.dou.commonutils.exception.MyException;
import com.dou.commonutils.util.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description 全局异常处理器
 * 统一异常处理类
 * @Date 2022/1/11 下午4:25
 */
@Slf4j
//当控制层出现异常时，由这个类处理
@ControllerAdvice
public class GlobalExceptionHandler {


    /**
     * 出现自定义异常时的处理方法
     */
    @ExceptionHandler(MyException.class)
    @ResponseBody
    public R error(MyException e){
        log.error(e.getMsg());      //异常输出语句
        e.printStackTrace();
        return R.error().message(e.getMsg()).code(e.getCode());
    }

    /**
     * 出现数字异常时的处理方法
     */
    @ExceptionHandler(ArithmeticException.class)
    @ResponseBody
    public R error(ArithmeticException e){
        log.error(e.getMessage());
        e.printStackTrace();
        return R.error().message("自定义数字异常已执行");
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public R error(Exception e) {
        log.error(e.getMessage());
        e.printStackTrace();
        return R.error();
    }
}
