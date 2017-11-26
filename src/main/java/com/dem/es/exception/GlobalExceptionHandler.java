package com.dem.es.exception;

import com.dem.es.util.ErrorInfo;
import com.dem.es.exception.MyException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * 全局错误处理
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    private static String PUBLIC_ERROR_PAGE = "/error/404";

    @ExceptionHandler(value = Exception.class)
    public ModelAndView defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
        System.out.println("-----");
        ModelAndView mav = new ModelAndView();
        mav.addObject("exception", e);
        mav.addObject("url", req.getRequestURL());
        mav.setViewName(PUBLIC_ERROR_PAGE);
        return mav;
    }

    /**
     * 捕获自定义异常错误
     * @param req
     * @param e
     * @return
     * @throws Exception
     */
    @ExceptionHandler(value = MyException.class)
    @ResponseBody
    public ErrorInfo<String> jsonErrorHandler(HttpServletRequest req, MyException e) throws Exception {
        ErrorInfo<String> r = new ErrorInfo<>();
        r.setMessage("" + e.getMessage());
        r.setCode(ErrorInfo.ERROR);
        r.setData("返回json出错");
        r.setUrl(req.getRequestURL().toString());
        return r;
    }

    @ExceptionHandler(value = IllegalArgumentException.class)
    @ResponseBody
    public ErrorInfo<String> argumentErr(HttpServletRequest req, IllegalArgumentException e) throws Exception {
        ErrorInfo<String> r = new ErrorInfo<>();
        r.setMessage("" + e.getMessage());
        r.setCode(ErrorInfo.ERROR);
        r.setData("jap查询参数不能为空");
        r.setUrl(req.getRequestURL().toString());
        return r;
    }
}
