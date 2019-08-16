package com.wyn.center.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 检查用户以及权限
 * Created by wxk on 2019/6/6.
 */
public class CheckAuthAndUser {

    private CheckAuthAndUser(){}

    /**
     * 判断用户是否有路径的访问权限
     * @param request
     * @return
     */
    public static boolean isHaveAuth(HttpServletRequest request){
        Object object=getObject(request,"longinuser");
        String name=object==null?"":object.toString();
        String url=request.getRequestURI();
        if(url.equals(name)){
            return true;
        }else {
            return false;
        }
    }

    /**
     * 判断用户是否已登录
     * @param request
     * @return
     */
    public static boolean isLogin(HttpServletRequest request){
           Object object=getObject(request,"longinuser");
           if(object==null){
               return false;
           }else {
               return true;
           }
    }

    /**
     * 根据key获取session中的对象
     * @param request
     * @param key
     * @return
     */
    public static Object getObject(HttpServletRequest request,String key){
        HttpSession session=request.getSession();
        Object object=session.getAttribute(key);
        return object;
    }

}
