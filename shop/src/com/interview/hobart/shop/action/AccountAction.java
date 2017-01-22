package com.interview.hobart.shop.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.interview.hobart.shop.entity.AccountInfo;

@Controller("accountAction")
@ParentPackage(value="json-default")
@Scope("prototype")
public class AccountAction extends BaseAction<AccountInfo> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Action(value="account_query", results={@Result(name = "jsonList", type = "json", 
			params={"root","jsonList","excludeProperties","\\[\\d+\\]\\.pass,\\[\\d+\\]\\.name"})})
	public String query() throws Exception {
		jsonList = accountService.query();
		return "jsonList";
	}
}
