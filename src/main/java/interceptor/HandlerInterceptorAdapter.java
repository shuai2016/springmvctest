package interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class HandlerInterceptorAdapter implements HandlerInterceptor {
     //省略代码 此处所以三个回调方法都是空实现，preHandle返回true。
     @Override
     public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
         return true;
     }
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
    }
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
     }
}