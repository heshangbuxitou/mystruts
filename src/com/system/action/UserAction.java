package com.system.action;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.system.domain.User;
import com.system.factory.BasicFactory;
import com.system.services.UserService;

public class UserAction extends ActionSupport{
	private User user = new User();
	private ActionContext ac = ActionContext.getContext();
	private Map request = (Map) ac.get("request");
	private HttpServletResponse response = ServletActionContext.getResponse();
	private HttpServletRequest request2 = ServletActionContext.getRequest();
	private Map session = (Map) ac.get("session");
	private Map param = ac.getParameters();
	UserService service = BasicFactory.getFactory().getInstance(UserService.class);
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String regist() throws Exception{
		String valistr[] = (String []) param.get("valistr");
		String validate = valistr[0];
		if(!validate.equals(ac.getSession().get("srand"))){
			System.out.println(user.getUsername()+","+user.getPassword()+","+valistr[0]+","+ac.getSession().get("srand"));
			request.put("msg", "验证码不正确，请输入正确的验证码！！");
			return "error";
		}else if(user.getPassword().length()<6){
			request.put("msg", "请输入长度大于6位的密码！！");
			return "error";
		}else if(user.getUsername()==null || user.getUsername().equals("") || user.getPassword()==null || user.getPassword().equals("")){
			request.put("msg", "请输入正确的信息!!");
			return "error";
		}else{
			service.addUser(user);
			user = service.findUserbyName(user.getUsername());
			session.put("user", user);
		}
		System.out.println(user.getUsername()+","+user.getPassword()+","+valistr[0]+","+ac.getSession().get("srand"));
		return "success";
	}
	
	public String login(){
		if(service.isUser(user.getUsername(),user.getPassword())==null){
			request.put("msg", "输入的用户名或密码错误！请输入正确的用户名和密码！!");
			return "error";
		}
		User user1 = service.findUserbyName(user.getUsername());
		session.put("user", user1);
		return "success";
	}
	
	public String watchtask(){
		if(session.get("user")==null){
			return "error";
		}
		String idd[] = (String []) param.get("id");
		String idd2 = idd[0];
		int id = Integer.parseInt(idd2);
		List list = service.getlist(id);
		request.put("list", list);
		return "success";
	}
	
	public String logout(){
		if(session.get("user")!=null){
			session.remove("user");
		}
		return "success";
	}
	
	public String watchuser(){
		List list = service.getuserlist();
		request.put("list", list);
		return "success";
	}
}
