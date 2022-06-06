package br.com.fiap.jpa.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;


import br.com.fiap.entity.MovimentacaoPortaria;

public class MovimentacaoPortariaDAOImpl extends HibernateGenericDAO<MovimentacaoPortaria, Long>{

	private static MovimentacaoPortariaDAOImpl instance = null;
	
	public static MovimentacaoPortariaDAOImpl getInstance() {
		if (instance == null) {
			instance = new MovimentacaoPortariaDAOImpl();
		}
		
		return instance;
	}
	
	private MovimentacaoPortariaDAOImpl() {
		super(MovimentacaoPortaria.class);
	}
	
	public List<MovimentacaoPortaria> listarPorTipo(String tipo, EntityManager entityManager) {
		String jpql = "SELECT m FROM MovimentacaoPortaria m WHERE m.tipo = :tipo";
		
		TypedQuery<MovimentacaoPortaria> consulta = entityManager.createQuery(jpql, MovimentacaoPortaria.class);
		consulta.setParameter("tipo", tipo.toUpperCase());
		
		return consulta.getResultList();
	}
}
