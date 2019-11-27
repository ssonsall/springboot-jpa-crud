package com.cos.crud.config;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.cos.crud.model.User;

@Component
public class LoginInterceptor extends HandlerInterceptorAdapter{

    private static final String LOGIN = "login";
    private static final Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, 
    Object handler,ModelAndView modelAndView) throws Exception {
        HttpSession session = request.getSession();
        ModelMap modelMap = modelAndView.getModelMap();
        User userVO = (User)modelMap.get("userVO");
        if(userVO != null){
            session.setAttribute(LOGIN, userVO);
            logger.info("================ Login session save");
        }
    }

    //컨트롤러보다 먼저 수행되는 메소드
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        HttpSession session = request.getSession();
        if(session.getAttribute(LOGIN) != null){
            session.removeAttribute(LOGIN);
        }
        return true;
    }

    @Override
	public void afterCompletion(HttpServletRequest request,
								HttpServletResponse response, 
								Object handler, 
								Exception ex) {
	}
}