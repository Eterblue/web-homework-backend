package com.hit.webhomework.interceptor;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hit.webhomework.enums.AppHttpCodeEnum;
import com.hit.webhomework.utils.JwtUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
@Component
public class AuthInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");
        if (!StrUtil.isBlank(token) && JwtUtils.verify(token)) {
            return true;
        }
        response.setCharacterEncoding("UTF-8");
        response.setStatus(AppHttpCodeEnum.NEED_LOGIN.getCode());
        response.getWriter().append(AppHttpCodeEnum.NEED_LOGIN.getMsg());
        return false;
    }
}
