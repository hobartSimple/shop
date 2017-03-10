package com.interview.hobart.shop.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.interview.hobart.shop.entity.ForderInfo;
import com.interview.hobart.shop.entity.StatusInfo;
import com.interview.hobart.shop.entity.UserInfo;

@Controller("forderAction")
@Scope("prototype")
public class ForderAction extends BaseAction<ForderInfo> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8319180077557187695L;

	@Override
	public ForderInfo getModel() {
		model = (ForderInfo) session.get("forder");
		return model;
	}

	// 实现购物车（订单）与购物项（订单项）级联入库功能
	@Action(value="forder_save", results={@Result(name="bank", type="redirect", location="/user/bank.jsp")})
	public String save() {
		model.setUser((UserInfo) session.get("user"));
		model.setStatus(new StatusInfo(1));
		forderService.save(model);

		// 此时购物车已经入库，那么原来session中的购物车就应该清空
		session.put("oldForder", session.get("forder"));// 先将原来的购物车信息保存下来，因为后面付款的时候还需要相关信息
		session.put("forder", new ForderInfo());// new一个新的空购物车（相当于清空了购物车），还可以方便用户再买~

		return "bank";
	}
}
