package com.interview.hobart.shop.action;

import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.ParameterAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.interview.hobart.shop.entity.ForderInfo;
import com.interview.hobart.shop.entity.UserInfo;
import com.interview.hobart.shop.model.BackData;
import com.interview.hobart.shop.model.SendData;

@Controller("payAction")
@Scope("prototype")
public class payAction extends BaseAction<Object> implements ParameterAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1611140934949484375L;

	private Map<String, String[]> parameters;

	@Override
	public Object getModel() {
		if (parameters.get("pd_FrpId") != null) {
			model = new SendData();
		} else {
			model = new BackData();
		}
		return model;
	}

	@Override
	public void setParameters(Map<String, String[]> parameters) {
		this.parameters = parameters;
	}
	
	@Action(value="pay_goBank", results={@Result(name="pay", type="redirect", location="/user/pay.jsp")})
	public String goBank(){
		SendData sendData = (SendData)model;
		//1. 补全参数:P2 p3 pd Pa需要从session中获取
		ForderInfo forder = (ForderInfo) session.get("oldForder");
		UserInfo user = (UserInfo) session.get("user");
		sendData.setP2_Order(forder.getId().toString()); //商户订单号
		sendData.setP3_Amt(forder.getTotal().toString()); //支付金额
		sendData.setPa_MP(user.getEmail() + "," + user.getPhone()); //商户扩展信息
		//2. 对参数进行追加		
		//3. 加密获取签名		
		//4. 存储到request域中
		payService.saveDataToRequest(request, sendData); //完成2,3,4
		//5. 跳转到支付页面
		
		return "pay";
	}

}
