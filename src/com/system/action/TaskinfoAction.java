package com.system.action;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.system.domain.Taskinfo;
import com.system.factory.BasicFactory;
import com.system.services.UserService;

public class TaskinfoAction extends ActionSupport {
	private Taskinfo taskinfo = new Taskinfo();
	private ActionContext ac = ActionContext.getContext();
	private Map request = (Map) ac.get("request");
	private HttpServletResponse response = ServletActionContext.getResponse();
	private HttpServletRequest request2 = ServletActionContext.getRequest();
	private Map session = (Map) ac.get("session");
	private Map param = ac.getParameters();
	UserService service = BasicFactory.getFactory().getInstance(UserService.class);

	public Taskinfo getTaskinfo() {
		return taskinfo;
	}


	public void setTaskinfo(Taskinfo taskinfo) {
		this.taskinfo = taskinfo;
	}

	
	public String addtask(){
		String idd[] = (String []) param.get("id");
		String idd2 = idd[0];
		int userid = Integer.parseInt(idd2);
		taskinfo.setUserid(userid);
		if(taskinfo.getEndtime()==null){
			request.put("msg", "请输入正确的时间格式！！！");
			return "error";
		}
//		System.out.println(taskinfo.getEndtime()+","+taskinfo.getRealtime()+","+taskinfo.getUserid());
		service.addtask(taskinfo);
		return "success";
	}
	
	public String findtask(){
		String idd[] = (String []) param.get("taskid");
		String idd2 = idd[0];
		int taskid = Integer.parseInt(idd2);
		Taskinfo taskinfo =  service.findtask(taskid);
		request.put("taskinfo", taskinfo);
		return "success";
	}
	
	public String modifytask(){
		String idd[] = (String []) param.get("taskid");
		String idd2 = idd[0];
		int taskid = Integer.parseInt(idd2);
		taskinfo.setTaskid(taskid);
		if(taskinfo.getStatus().equals("已完成") && taskinfo.getRealtime()==null){
			taskinfo.setRealtime(new Date());
			System.out.println(taskinfo.getRealtime());
		}
		service.modifytask(taskinfo);
		return "success";
	}
	public String deletetask(){
		String idd[] = (String []) param.get("taskid");
		String idd2 = idd[0];
		int taskid = Integer.parseInt(idd2);
		service.deletetask(taskid);
		return "success";
	}
}
