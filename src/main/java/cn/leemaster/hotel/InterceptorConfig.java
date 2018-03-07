package cn.leemaster.hotel;

import cn.leemaster.hotel.inteceptor.AdminInterceptor;
import cn.leemaster.hotel.inteceptor.UserInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author leemaster
 * @version V1.0
 * @Project hotel
 * @Title AdapterClass.java created on 18-3-6
 * @Package cn.leemaster.hotel
 * @Describtion
 * 设置拦截器 拦截用户登录系统
 * 其他的各种操作
 * @since v1.0
 */
@Configuration
public class InterceptorConfig extends WebMvcConfigurerAdapter{

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new UserInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/login")
                .excludePathPatterns("/register")
                .excludePathPatterns("/")
                .excludePathPatterns("/admin/**");

        registry.addInterceptor(new AdminInterceptor())
                .addPathPatterns("/admin/**")
                .excludePathPatterns("/admin/login");

        super.addInterceptors(registry);
    }
}
