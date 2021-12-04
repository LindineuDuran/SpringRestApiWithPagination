package br.com.lduran.restapipagination.domain.exception;

public class FuncionarioNaoEncontradoException extends EntidadeNaoEncontradaException
{
	private static final long serialVersionUID = 1L;

	public FuncionarioNaoEncontradoException(String mensagem)
	{
		super(mensagem);
	}

	public FuncionarioNaoEncontradoException(Long estadoId)
	{
		this(String.format("Não existe um cadastro de restaurante de código %d", estadoId));
	}
}
