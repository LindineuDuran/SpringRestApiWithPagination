package br.com.lduran.restapipagination.api.model;

import java.util.List;

import org.springframework.data.domain.Page;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PaginacaoDto
{
	// ##### ATRIBUTOS #####
	private static final long serialversionUID = 1L;

	@JsonProperty("customers")
	private List<FuncionarioDto> listaFuncionarios;

	@JsonProperty("pagina_atual")
	private int paginaAtual;

	@JsonProperty("qtde_registros atual")
	private long qtdeRegistrosAtual;

	@JsonProperty("pagina_total")
	private int paginaTotal;

	@JsonProperty("atde_registros_total")
	private long qtdeRegistrosTotal;

	// #### Classe DTO com todas as informações de paginação que serão apresentadas
	// no JSON de retorno ####
	// ##### CONSTRUTORES #####
	public PaginacaoDto(Page<FuncionarioDto> paginaRetorno, Boolean count)
	{
		if (count)
		{
			this.qtdeRegistrosTotal = paginaRetorno.getTotalElements();
		}
		else
		{
			this.listaFuncionarios = paginaRetorno.getContent();
			this.paginaAtual = paginaRetorno.getNumber();
			this.qtdeRegistrosAtual = paginaRetorno.getNumberOfElements();
			this.paginaTotal = paginaRetorno.getTotalPages() - 1;
			this.qtdeRegistrosTotal = paginaRetorno.getTotalElements();
		}
	}
}
