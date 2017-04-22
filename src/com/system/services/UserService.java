package com.system.services;

import java.util.List;

import com.system.domain.Taskinfo;
import com.system.domain.User;

public interface UserService {
	/**
	 *  �����û��������û�
	 * @param username
	 * @return һ���û�
	 */
	User findUserbyName(String username);
	/**
	 * ע��ɹ��������ݿ��м���ע��ɹ����û�
	 * @param user
	 */
	void addUser(User user);
	/**
	 * �����û��������뷵���û�
	 * @return һ���û�
	 */
	User isUser(String username,String password);
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
	 * �޸ĸ�������id�޸�����
	 * @param taskinfo
	 */
	void modifytask(Taskinfo taskinfo);
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
