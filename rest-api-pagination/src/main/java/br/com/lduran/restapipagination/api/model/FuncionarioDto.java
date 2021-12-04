package br.com.lduran.restapipagination.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FuncionarioDto
{
	private String nome;
	private String email;
	private String funcao;
}