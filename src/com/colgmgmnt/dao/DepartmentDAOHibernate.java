package com.colgmgmnt.dao;



import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DepartmentDAOHibernate {
	SessionFactory factory;
	
	public DepartmentDAOHibernate(){
		Configuration conf = new Configuration();
		conf.configure("com/colgmgmnt/dao/hibernate.cfg.xml");
		factory= conf.buildSessionFactory();
		
	}
	
	
}
