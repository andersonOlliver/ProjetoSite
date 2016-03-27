package br.com.bb.intranet.supermt.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.bb.intranet.supermt.model.Noticia;
import br.com.bb.intranet.supermt.repository.Noticias;
import br.com.bb.intranet.supermt.service.CadastroNoticias;
import br.com.bb.intranet.supermt.service.NoticiaException;

@Named
@ViewScoped
public class ConsultaNoticiasBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private Noticias noticiasRepositorio;
	
	@Inject
	private CadastroNoticias cadastro;
	
	private Noticia noticiaSelecionada;
	
	private List<Noticia> noticias;
	
	public void consultar(){
		this.noticias = noticiasRepositorio.todos();
	}

	public void excluir(){
		FacesContext context = FacesContext.getCurrentInstance();
		
		try{
			this.cadastro.excluir(this.noticiaSelecionada);
			this.consultar();
			
			context.addMessage(null, new FacesMessage("Notícia excluída com sucesso!"));
		} catch(NoticiaException ne) {
			FacesMessage mensagem = new FacesMessage(ne.getMessage());
			mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
			context.addMessage(null, mensagem);
		}
	}
	
	public List<Noticia> getNoticias() {
		return noticias;
	}

	public Noticia getNoticiaSelecionada() {
		return noticiaSelecionada;
	}

	public void setNoticiaSelecionada(Noticia noticiaSelecionada) {
		this.noticiaSelecionada = noticiaSelecionada;
	}


	
}
