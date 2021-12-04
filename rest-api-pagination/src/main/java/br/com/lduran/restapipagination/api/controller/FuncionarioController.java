package br.com.lduran.restapipagination.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.lduran.restapipagination.api.assembler.FuncionarioDtoAssembler;
import br.com.lduran.restapipagination.api.model.FuncionarioDto;
import br.com.lduran.restapipagination.api.model.PaginacaoDto;
import br.com.lduran.restapipagination.domain.FuncionarioService;
import br.com.lduran.restapipagination.domain.model.Funcionario;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController
{
	@Autowired
	FuncionarioService service;

	@Autowired
	private FuncionarioDtoAssembler assembler;

	@GetMapping
	public ResponseEntity<List<PaginacaoDto>> getAll(
			@RequestParam(value = "page", required = false, defaultValue = "0") int page,
			@RequestParam(value = "size", required = false, defaultValue = "50") int size,
			@RequestParam(value = "count", required = false, defaultValue = "false") Boolean count)
	{
		Page<Funcionario> customersPage = service.listar(page, size);
		List<Funcionario> funcionarioList = customersPage.getContent();

		List<FuncionarioDto> funcionarioDtoList = assembler.toCollectionModel(funcionarioList);

		PageRequest pageRequest = PageRequest.of(page, size, Sort.Direction.ASC, "nome");

		Page<FuncionarioDto> customerDTOPage = new PageImpl<FuncionarioDto>(funcionarioDtoList, pageRequest,
				customersPage.getTotalElements());

		if (customerDTOPage.getNumberOfElements() > 0)
		{
			List<PaginacaoDto> objRetorno = new ArrayList<>();
			objRetorno.add(new PaginacaoDto(customerDTOPage, count));
			return ResponseEntity.ok(objRetorno);
		}
		else
		{
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/{funcionarioId}")
	public FuncionarioDto buscar(@PathVariable Long funcionarioId)
	{
		Funcionario funcionario = service.buscar(funcionarioId);

		return assembler.toModel(funcionario);
	}
}
