package com.hj.car.rent.common.handler;

import com.hj.car.rent.common.constant.Result;
import com.hj.car.rent.common.constant.ResultCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
    private Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 系统异常处理，比如：404,500
     * @param req 请求
     * @param e 异常
     * @return Result
     * @throws Exception 异常
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
        logger.error("Catch an exception, cause: ", e);
        if (e instanceof NoHandlerFoundException) {
            return Result.failure(ResultCode.URI_NOT_FOUND);
        }
        return Result.failure(ResultCode.ERROR);
    }
}
