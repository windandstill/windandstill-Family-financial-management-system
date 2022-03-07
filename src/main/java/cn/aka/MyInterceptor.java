package cn.aka;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyInterceptor  implements HandlerInterceptor {
    private long begintime;
    private long endtime1;
    private long endtime2;
    //执行处理方法之前，返回true才能让处理器方法执行
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("preHandle");
        begintime = System.currentTimeMillis();
        return true;
    }

    //处理方法执行完毕
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        endtime1 = System.currentTimeMillis();
        System.out.println("方法的执行时间:" + (endtime1 - begintime));
    }

    //在处理方法执行完毕，响应已发往前端
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        endtime2 = System.currentTimeMillis();
        System.out.println("全部过程的执行时间:" + (endtime2 - begintime));
    }
}
