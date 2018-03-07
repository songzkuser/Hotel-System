package cn.leemaster.hotel.inteceptor;

import cn.leemaster.hotel.ResponseModel;
import com.alibaba.fastjson.JSON;
import jdk.nashorn.internal.parser.JSONParser;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

/**
 * @author leemaster
 * @version V1.0
 * @Project hotel
 * @Title AdapterClass.java created on 18-3-6
 * @Package cn.leemaster.hotel.inteceptor
 * @Describtion
 * 用户登录状态拦截器
 * 简单的安全防护 防止没有携带Token的请求，正常的话要使用Redis 进行认证的 如果认证失败 那么不应该返回
 * 这里简单使用 不使用Redis 了
 * @since v1.0
 */
public class UserInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        String token = httpServletRequest.getParameter("token");
        if(token == null){

            httpServletResponse.setHeader("Content-Type","application/json;charset=utf-8");

            ResponseModel model = new ResponseModel();

            model.setResponseCode(403);

            model.setResponseStatus("用户未登录，不允许操作");

            model.setResponseData(new HashMap<>());

            httpServletResponse.getWriter().write(JSON.toJSONString(model));

            return false;

        }else{
            return true;
        }
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
