package com.colgmgmnt.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.colgmgmnt.entity.College;

public class CollegeDAOHibernate {

	SessionFactory factory;
	Session session;

	public CollegeDAOHibernate() {
		Configuration cnf = new Configuration();
		cnf.configure("com/colgmgmnt/dao/hibernate.cfg.xml");
		factory = cnf.buildSessionFactory();
	}

	public College getCollegeRecordById(int collegeId) {
		 session = factory.openSession();
		College college = (College) session.load(College.class, collegeId);
		return college;
	}

//	public List getAllCollegeRecord(){
//		session =factory.openSession();
//		
//	}

	
}
