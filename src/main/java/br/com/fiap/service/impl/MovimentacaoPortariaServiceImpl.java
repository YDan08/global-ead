package br.com.fiap.service.impl;

import java.util.List;

import br.com.fiap.entity.MovimentacaoPortaria;
import br.com.fiap.jpa.dao.impl.MovimentacaoPortariaDAOImpl;
import br.com.fiap.jpa.service.GenericService;

public class MovimentacaoPortariaServiceImpl extends GenericService<MovimentacaoPortaria, Long>{

	private static MovimentacaoPortariaServiceImpl instance = null;
	
	private MovimentacaoPortariaDAOImpl movimentoDAO;
	
	private MovimentacaoPortariaServiceImpl() {
		movimentoDAO = MovimentacaoPortariaDAOImpl.getInstance();
	}
	
	public static MovimentacaoPortariaServiceImpl getInstance() {
		
		if (instance == null) {
			instance = new MovimentacaoPortariaServiceImpl();
		}
		
		return instance;
	}

	@Override
	public void cadastrar(MovimentacaoPortaria movimento) {
		try {
			movimentoDAO.salvar(movimento, getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
			getEntityManager().getTransaction().rollback();
		} finally {
			closeEntityManager();
		}
	}

	@Override
	public void atualizar(MovimentacaoPortaria movimento) {
		try {
			movimentoDAO.atualizar(movimento, getEntityManager());
		} catch (Exception e) {
			getEntityManager().getTransaction().rollback();
		} finally {
			closeEntityManager();
		}
	}

	@Override
	public void remover(Long id) {
		try {
			movimentoDAO.remover(id, getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
			getEntityManager().getTransaction().rollback();
		} finally {
			closeEntityManager();
		}
	}

	@Override
	public MovimentacaoPortaria obter(Long id) {
		MovimentacaoPortaria movimento = null;
		
		try {
			movimento = movimentoDAO.obterPorId(id, getEntityManager());
		} catch (Exception e) {
		} finally {
			closeEntityManager();
		}
		
		return movimento;
	}

	@Override
	public List<MovimentacaoPortaria> listar() {
		List<MovimentacaoPortaria> movimentos = null;
		
		try {
			movimentos = movimentoDAO.listar(getEntityManager());
		} catch (Exception e) {
		} finally {
			closeEntityManager();
		}
		
		return movimentos;
	}
	
	public List<MovimentacaoPortaria> ListarPorTipo(String tipo) {
		List<MovimentacaoPortaria> movimentos = null;
		
		try {
			movimentos = movimentoDAO.listarPorTipo(tipo,getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeEntityManager();
		}
		
		return movimentos;
	}
}
