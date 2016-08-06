package com.interview.hobart.shop.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @Description: TODO(此Action用来完成WEB-INF中JSP与JSP请求转发功能，此Action不处理任何的逻辑)
 * @author hobart
 *
 */
@Controller
public class SendAction extends ActionSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Action(value="send_*_*", results={@Result(name="send",location="/WEB-INF/{1}/{2}.jsp")})
	public String execute() throws Exception {
		return "send";
	}
}
