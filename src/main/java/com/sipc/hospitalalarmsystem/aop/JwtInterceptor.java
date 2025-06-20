package com.sipc.hospitalalarmsystem.aop;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sipc.hospitalalarmsystem.model.dto.CommonResult;
import com.sipc.hospitalalarmsystem.util.JwtUtils;
import com.sipc.hospitalalarmsystem.util.RedisUtil;
import com.sipc.hospitalalarmsystem.util.TokenThreadLocalUtil;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.constraints.NotNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
@Slf4j
public class JwtInterceptor implements HandlerInterceptor {

    @Resource
    RedisUtil redisUtil;

    @Autowired
    ClearRedisImpl clearRedisImpl;

    @Override
    public boolean preHandle(HttpServletRequest request, @NotNull HttpServletResponse response, @NotNull Object handler) throws Exception {
        String token = request.getHeader("Authorization");
        if (!(handler instanceof HandlerMethod handlerMethod)) {
            return true;
        }
        //如果没有@Pass注解，直接放行
        Pass pass = handlerMethod.getMethodAnnotation(Pass.class);
        if (pass != null) {
            return true;
        }
        ClearRedis clearRedis = handlerMethod.getMethodAnnotation(ClearRedis.class);
        if (clearRedis != null) {
            //和redis配置类保持一致
            clearRedisImpl.deleteCache();
        }

        if (null == token || token.isEmpty() || !JwtUtils.verify(token)) {
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json; charset=utf-8");
            ObjectMapper objectMapper = new ObjectMapper();
            if (!(null == token || token.isEmpty())) {
                response.getWriter().println(objectMapper.writeValueAsString(CommonResult.tokenWrong()));
            } else {
                response.getWriter().println(objectMapper.writeValueAsString(CommonResult.tokenNull()));
            }
            log.warn("token验证失败");
            log.warn("token: " + token);
            log.warn("url: " + request.getRequestURL());
            log.warn("header: " + request.getHeader("Authorization"));
            return false;
        }
        TokenThreadLocalUtil.getInstance().bind(token);
        return true;
    }

    @Override
    public void postHandle(@NotNull HttpServletRequest request, @NotNull HttpServletResponse response, @NotNull Object handler, ModelAndView modelAndView) throws Exception {
    }
//
    @Override
    public void afterCompletion(@NotNull HttpServletRequest request, @NotNull HttpServletResponse response, @NotNull Object handler, Exception ex) throws Exception {
    }

}
