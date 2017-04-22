package com.system.dao;

import java.util.List;

import com.system.domain.Taskinfo;
import com.system.domain.User;

public interface UserDao {
	/**
	 * 根据名字返回用户
	 * @param username
	 * @return 一个用户
	 */
	User findUserbyName(String username);
	
	/**
	 * 添加用户
	 * @param user
	 */
	void addUser(User user);
	/**
	 * 根据用户名和密码返回用户
	 * @param username
	 * @param password
	 * @return 一个用户
	 */
	User isUser(String username, String password);
	/**
	 * 根据用户id返回用户的任务列表
	 * @param id
	 * @return 任务list
	 */
	List<Taskinfo> getlist(int id);
	/**
	 * 添加一个用户任务
	 * @param taskinfo
	 */
	void addtask(Taskinfo taskinfo);
	/**
	 * 根据任务id查找任务
	 * @param taskid
	 * @return 一个任务
	 */
	Taskinfo findtask(int taskid);
	/**
	 * 根据任务id修改任务
	 * @param taskinfo
	 */
	void mofifytask(Taskinfo taskinfo);
	/**
	 * 根据任务id删除任务
	 * @param taskid
	 */
	void deletetask(int taskid);
	/**
	 * 返回所有用户不包括管理员
	 * @return
	 */
	List getuserlist();

}
