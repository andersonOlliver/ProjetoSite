package br.com.bb.intranet.supermt.service;

import java.io.Serializable;
import java.util.Date;

import javax.inject.Inject;

import br.com.bb.intranet.supermt.model.Noticia;
import br.com.bb.intranet.supermt.repository.Noticias;
import br.com.bb.intranet.supermt.util.Transactional;

public class CadastroNoticias implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Noticias noticias;

	
	@Transactional
	public void salvar(Noticia noticia) throws NoticiaException {
		if(noticia.getDataRetirada() != null &&
				noticia.getDataRetirada().before(new Date())){
			throw new NoticiaException("Data de expiração não pode ser uma data passadaa.");
		}
		this.noticias.guardar(noticia);
	}
	
	@Transactional
	public void excluir(Noticia noticia) throws NoticiaException{
		noticia = this.noticias.porId(noticia.getIdNoticia());
		
		if(noticia.getDataRetirada().after(new Date())){
			throw new NoticiaException("Não é possível excluir notícia em Histórico!");
		}
		this.noticias.remover(noticia);
	}
}
