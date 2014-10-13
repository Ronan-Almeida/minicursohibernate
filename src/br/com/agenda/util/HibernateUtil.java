package br.com.agenda.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static final SessionFactory sessionFactory;

	static {
		try {
			Configuration cfg = new Configuration()
					.configure("hibernate.cfg.xml");
			StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();
			sb.applySettings(cfg.getProperties());
			StandardServiceRegistry standardServiceRegistry = sb.build();
			sessionFactory = cfg.buildSessionFactory(standardServiceRegistry);
		} catch (Throwable th) {
			System.err.println("Erro ao criar a SessionFactory: " + th);
			throw new ExceptionInInitializerError(th);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
