package br.com.lduran.restapipagination.api.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.lduran.restapipagination.api.model.FuncionarioDto;
import br.com.lduran.restapipagination.domain.model.Funcionario;

@Component
public class FuncionarioDtoAssembler
{
	@Autowired
	private ModelMapper modelMapper;

	public FuncionarioDto toModel(Funcionario funcionario)
	{
		return modelMapper.map(funcionario, FuncionarioDto.class);
	}

	public List<FuncionarioDto> toCollectionModel(List<Funcionario> funcionarios)
	{
		return funcionarios.stream().map(funcionario -> toModel(funcionario)).collect(Collectors.toList());
	}
}
