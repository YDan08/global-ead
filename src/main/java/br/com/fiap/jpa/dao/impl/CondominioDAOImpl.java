package br.com.fiap.jpa.dao.impl;

import br.com.fiap.entity.Condominio;

public class CondominioDAOImpl extends HibernateGenericDAO<Condominio, Long> {

	private static CondominioDAOImpl instance = null;
	
	public static CondominioDAOImpl getInstance() {
		if(instance == null) {
			instance = new CondominioDAOImpl();
		}
		return instance;
	}
	
	public CondominioDAOImpl() {
		super(Condominio.class);
	}
}
