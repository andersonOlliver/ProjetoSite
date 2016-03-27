package br.com.bb.intranet.supermt.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {

	private static EntityManagerFactory factory;
	
	static{
		factory = Persistence.createEntityManagerFactory("SitePU");
	}
	
	public static EntityManager getEntityManager(){
		return factory.createEntityManager();
	}
}
