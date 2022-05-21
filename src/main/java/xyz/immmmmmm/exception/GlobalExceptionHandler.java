package xyz.immmmmmm.exception;



import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import xyz.immmmmmm.common.R;

import java.sql.SQLIntegrityConstraintViolationException;

// 定义一个全局异常类，这个类中的方法会捕捉到对应的异常，并执行方法

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public R handlerSqlException(SQLIntegrityConstraintViolationException e){

        String message = e.getMessage();

        if(message.contains("Duplicate entry")){
            return R.error(message.split(" ")[2] + "已存在");
        }else{
            return R.error("数据异常");
        }
    }

    @ExceptionHandler(NullPointerException.class)
    public R NullPointerException(NullPointerException e){

        String message = e.getMessage();
        System.out.println(message);

        if(message.contains("null")){
            return R.error("数据库返回异常");
        }else{
            return R.error("数据异常");
        }

    }
}
