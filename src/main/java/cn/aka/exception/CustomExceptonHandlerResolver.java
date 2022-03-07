package cn.aka.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CustomExceptonHandlerResolver implements HandlerExceptionResolver {
    private CustomException customException;
    //任何层级抛出的异常都会被该方法进行处理
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        //判断当前的异常是自定义的还是运行时的
        if(e instanceof CustomException){
            customException = (CustomException) e;
        }else{
            customException = new CustomException("未知的异常");
        }
        ModelAndView mv = new ModelAndView();
        mv.addObject("errInfo", customException.getMessage());
        mv.setViewName("error");
        return mv;
    }
}
