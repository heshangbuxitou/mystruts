package com.system.dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.system.domain.Taskinfo;
import com.system.domain.User;
import com.system.utils.HibernateUtils;

public class UserDaoImpl implements UserDao {
	private Session session = HibernateUtils.getSession();
	@Override
	public User findUserbyName(String username) {
		String hql = "from User where username = ?";
		Query query = session.createQuery(hql);
		query.setParameter(0, username);
		query.setMaxResults(1);
		return (User) query.uniqueResult();
	}

	@Override
	public void addUser(User user) {
		Transaction tx = session.beginTransaction();
		session.save(user);
		tx.commit();
	}

	@Override
	public User isUser(String username, String password) {
		String hql = "from User where username = ? and password = ?";
		Query query = session.createQuery(hql);
		query.setParameter(0, username);
		query.setParameter(1, password);
		query.setMaxResults(1);
		return (User) query.uniqueResult();
	}

	@Override
	public List<Taskinfo> getlist(int id) {
		String hql = "from Taskinfo where userid = ?";
		Query query = session.createQuery(hql);
		query.setParameter(0, id);
		System.out.println(query.getQueryString());
		List<Taskinfo> list =  query.list();
		return list;
	}

	@Override
	public void addtask(Taskinfo taskinfo) {
		Transaction tx = session.beginTransaction();
		session.save(taskinfo);
		tx.commit();
	}

	@Override
	public Taskinfo findtask(int taskid) {
		String hql = "from Taskinfo where taskid = ?";
		Query query = session.createQuery(hql);
		query.setParameter(0, taskid);
		query.setMaxResults(1);
		return (Taskinfo) query.uniqueResult();
	}

	@Override
	public void mofifytask(Taskinfo taskinfo) {
		String hql = "update Taskinfo set title =?,content=?,status=?,result=?,realtime=?,endtime=? where taskid=? ";
		Query query = session.createQuery(hql);
		query.setParameter(0, taskinfo.getTitle());
		query.setParameter(1, taskinfo.getContent());
		query.setParameter(2, taskinfo.getStatus());
		query.setParameter(3, taskinfo.getResult());
		query.setParameter(4, taskinfo.getRealtime());
		query.setParameter(5, taskinfo.getEndtime());
		query.setParameter(6, taskinfo.getTaskid());
		query.executeUpdate();
	}

	@Override
	public void deletetask(int taskid) {
		String hql = "delete Taskinfo where taskid=?";
		Query query = session.createQuery(hql);
		query.setParameter(0, taskid);
		query.executeUpdate();
	}

	@Override
	public List getuserlist() {
		String hql = "from User";
		Query query = session.createQuery(hql);
		return query.list();
	}

}
