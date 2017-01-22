package com.interview.hobart.shop.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.interview.hobart.shop.entity.UserInfo;

@Controller("userAction")  
@Scope("prototype")  
public class UserAction extends BaseAction<UserInfo> {

	private static final long serialVersionUID = -1735178903148713102L;
	
	@Action(value="user_login", results={@Result(name="login", location="/ulogin.jsp"),
			@Result(name="index", location="/index.jsp"),
			@Result(name="goURL", type="redirect", location="/index.jsp")})
	public String login() {  
        //进行登陆的判断  
        model = userService.login(model);  
        if(model == null) {  
            session.put("error", "登陆失败");  
            return "login";  
        } else {  
            //登录成功，先将用户存储到session中  
            session.put("user", model);  
            //根据session中goURL是否有值而决定页面的跳转  
            if(session.get("goURL") == null) {  
                return "index"; //跳到首页  
            } else {  
                return "goURL";  
            }  
        }  
    }  
}
