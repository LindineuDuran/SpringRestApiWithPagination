package br.com.lduran.restapipagination.core.modelmapper;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.lduran.restapipagination.api.model.FuncionarioDto;
import br.com.lduran.restapipagination.domain.model.Funcionario;

@Configuration
public class ModelMapperConfig
{
	@Bean
	public ModelMapper modelMapper()
	{
		var modelMapper = new ModelMapper();

		var funcionarioToFuncionarioDtoTypeMap = modelMapper.createTypeMap(Funcionario.class, FuncionarioDto.class);

		funcionarioToFuncionarioDtoTypeMap.<String>addMapping(funcionarioSrc -> funcionarioSrc.getCargo().getFuncao(),
				(funcionarioDtoDest, value) -> funcionarioDtoDest.setFuncao(value));

		return modelMapper;
	}
}
