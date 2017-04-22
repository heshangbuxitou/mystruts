package com.system.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
	private static SessionFactory sf;
	static {
		// 加载主配置文件, 并创建Session的工厂
		sf = new Configuration().configure().buildSessionFactory();
	}
	
	// 创建Session对象
	public static Session getSession(){
		return sf.openSession();
	}
	
}
