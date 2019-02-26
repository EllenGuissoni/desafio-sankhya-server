package br.com.ellen.restapi.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.ellen.restapi.model.Lancamento;

@Repository
public class LancamentoDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	public List<Lancamento> buscarTodos() {
		return getCurrentSession().createQuery("from Lancamento").list();
	}

	public Lancamento salvar(Lancamento lancamento) {
		getCurrentSession().saveOrUpdate(lancamento);
		return lancamento;
	}

	public void deletarPeloId(Integer id) {
		Query query = getCurrentSession().createSQLQuery("delete from Lancamento where id = :id");
		query.setParameter("id", id);
		query.executeUpdate();
	}

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

}
