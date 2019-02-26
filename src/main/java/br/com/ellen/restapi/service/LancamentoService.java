package br.com.ellen.restapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.ellen.restapi.dao.LancamentoDao;
import br.com.ellen.restapi.model.Lancamento;

@Service
public class LancamentoService {

	@Autowired
	private LancamentoDao dao;

	@Transactional
	public List<Lancamento> buscarTodosOsLancamentos() {
		return dao.buscarTodos();
	}

	@Transactional
	public Lancamento salvarLancamento(Lancamento lancamento) {
		return dao.salvar(lancamento);
	}

	@Transactional
	public void deletarLancamentoPeloId(Integer id) {
		dao.deletarPeloId(id);
	}

}
