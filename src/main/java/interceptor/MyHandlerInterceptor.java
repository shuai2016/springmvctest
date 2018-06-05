package interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyHandlerInterceptor extends HandlerInterceptorAdapter {//此处一般继承HandlerInterceptorAdapter适配器即可
    @Override  
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String contextPath = request.getContextPath();
        request.setAttribute("base",contextPath);
        return true;  
    }
} 