package com.neuedu.jstu.myoffice.interceptor;

import com.neuedu.jstu.myoffice.bean.ResultBean;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class LoginInterceptor implements HandlerInterceptor {
    private List<String> excludeUrls; //与配置文件中相同

    public void setExcludeUrls(List<String> excludeUrls){
        this.excludeUrls = excludeUrls;
    }
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //登录页面允许显示
        String url = request.getRequestURI().replaceFirst(request.getContextPath(),"");
        for(String excludeUrl:excludeUrls){
            if(url.startsWith(excludeUrl)){
                return true;
            }
        }

        //是否登录,没有登录，转向登录页面
        ResultBean resultBean = (ResultBean) request.getSession().getAttribute("myoffices");
        if(null == resultBean || null == resultBean.getData()){
            //没有登录请求
            if(!response.isCommitted()){
                //不是前端页面，所以此处需要提供详细地址
                response.sendRedirect(request.getContextPath()+"/login");
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
