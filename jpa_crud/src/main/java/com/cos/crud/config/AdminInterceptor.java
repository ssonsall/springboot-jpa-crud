package com.cos.crud.config;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.cos.crud.model.User;

@Component
public class AdminInterceptor extends HandlerInterceptorAdapter{
/*
    public static String makeUri(String uri){
        if(uri.contains("board")){
            return "/board/list";
        }else if(uri.contains("user")){
            return "/user/list";
        }
        return "/";
    }

    //컨트롤러보다 먼저 수행되는 메소드
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        HttpSession session = request.getSession();
        String prevUri = makeUri(request.getRequestURI());
        if(session.getAttribute("login") != null){ //로그인 되어있음
            User userVO = (User)session.getAttribute("login");
            if(!userVO.getName().equals("admin")){
                response.sendRedirect(prevUri);
                return false;
            }
        }else{
            response.sendRedirect(prevUri);
            return false;
        }
        return true;
    }
    */
}