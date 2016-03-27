package br.com.bb.intranet.supermt.service;

import java.io.Serializable;

import javax.inject.Inject;

import br.com.bb.intranet.supermt.model.Navegacao;
import br.com.bb.intranet.supermt.repository.Navegacoes;
import br.com.bb.intranet.supermt.util.Transactional;

public class CadastroNavegacao implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Navegacoes navegacoes;
	
	@Transactional
	public void salvar(Navegacao navegacao) throws NavegacaoException{
		if(navegacao.getUsuario() == null){
			throw new NavegacaoException("Usuário não pode ser nulo!");
		}
		if(navegacao.getPagina()== null || navegacao.getPagina().equals("")){
			throw new NavegacaoException("Pagina não pode ser vazia ou nula!");
		}
		this.navegacoes.adicionar(navegacao);
	}
	
	
}
