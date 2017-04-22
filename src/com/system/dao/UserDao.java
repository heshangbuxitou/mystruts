package com.system.dao;

import java.util.List;

import com.system.domain.Taskinfo;
import com.system.domain.User;

public interface UserDao {
	/**
	 * �������ַ����û�
	 * @param username
	 * @return һ���û�
	 */
	User findUserbyName(String username);
	
	/**
	 * ����û�
	 * @param user
	 */
	void addUser(User user);
	/**
	 * �����û��������뷵���û�
	 * @param username
	 * @param password
	 * @return һ���û�
	 */
	User isUser(String username, String password);
	/**
	 * �����û�id�����û��������б�
	 * @param id
	 * @return ����list
	 */
	List<Taskinfo> getlist(int id);
	/**
	 * ���һ���û�����
	 * @param taskinfo
	 */
	void addtask(Taskinfo taskinfo);
	/**
	 * ��������id��������
	 * @param taskid
	 * @return һ������
	 */
	Taskinfo findtask(int taskid);
	/**
	 * ��������id�޸�����
	 * @param taskinfo
	 */
	void mofifytask(Taskinfo taskinfo);
	/**
	 * ��������idɾ������
	 * @param taskid
	 */
	void deletetask(int taskid);
	/**
	 * ���������û�����������Ա
	 * @return
	 */
	List getuserlist();

}
