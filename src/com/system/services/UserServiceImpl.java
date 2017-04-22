package com.system.services;

import java.util.List;

import com.system.dao.UserDao;
import com.system.domain.Taskinfo;
import com.system.domain.User;
import com.system.factory.BasicFactory;

public class UserServiceImpl implements UserService {
	UserDao dao = BasicFactory.getFactory().getInstance(UserDao.class);
	@Override
	public User findUserbyName(String username) {
		return dao.findUserbyName(username);
	}

	@Override
	public void addUser(User user) {
		if(dao.findUserbyName(user.getUsername())!=null){
			throw new RuntimeException("这个用户已经存在！！");
		}
		dao.addUser(user);
	}

	@Override
	public User isUser(String username, String password) {
		return dao.isUser(username, password);
	}

	@Override
	public List<Taskinfo> getlist(int id) {
		return dao.getlist(id);
	}

	@Override
	public void addtask(Taskinfo taskinfo) {
		dao.addtask(taskinfo);
	}

	@Override
	public Taskinfo findtask(int taskid) {
		return dao.findtask(taskid);
	}

	@Override
	public void modifytask(Taskinfo taskinfo) {
		dao.mofifytask(taskinfo);
	}

	@Override
	public void deletetask(int taskid) {
		dao.deletetask(taskid);
	}

	@Override
	public List getuserlist() {
		return dao.getuserlist();
	}

}
