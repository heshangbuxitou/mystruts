package com.system.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
	private static SessionFactory sf;
	static {
		// �����������ļ�, ������Session�Ĺ���
		sf = new Configuration().configure().buildSessionFactory();
	}
	
	// ����Session����
	public static Session getSession(){
		return sf.openSession();
	}
	
}
