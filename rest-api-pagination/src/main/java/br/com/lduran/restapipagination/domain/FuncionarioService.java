package br.com.lduran.restapipagination.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.lduran.restapipagination.domain.exception.FuncionarioNaoEncontradoException;
import br.com.lduran.restapipagination.domain.model.Funcionario;
import br.com.lduran.restapipagination.domain.repository.FuncionarioRepository;

@Service
public class FuncionarioService
{
	@Autowired
	private FuncionarioRepository repository;

	public Page<Funcionario> listar(int page, int size)
	{
		PageRequest pageRequest = PageRequest.of(page, size, Sort.Direction.ASC, "nome");
		return repository.findAll(pageRequest);
	}

	public Funcionario buscar(Long funcionarioId)
	{
		return this.repository.findById(funcionarioId)
				.orElseThrow(() -> new FuncionarioNaoEncontradoException(funcionarioId));
	}
}
