package br.com.ellen.restapi.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ellen.restapi.model.Lancamento;
import br.com.ellen.restapi.service.LancamentoService;

@RestController
@RequestMapping("lancamentos")
public class LancamentoResource {

	@Autowired
	private LancamentoService lancamentoService;

	@GetMapping
	public List<Lancamento> buscarTodosOsLancamentos() {
		return lancamentoService.buscarTodosOsLancamentos();
	}

	@PostMapping
	public Lancamento salvarLancamento(@RequestBody Lancamento transaction) {
		return lancamentoService.salvarLancamento(transaction);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletarLancamentoPeloId(@PathVariable Integer id) {
		lancamentoService.deletarLancamentoPeloId(id);

		return new ResponseEntity<>(HttpStatus.OK);
	}

}
