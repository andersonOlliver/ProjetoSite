package br.com.bb.intranet.supermt.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.bb.intranet.supermt.model.EstadoNoticia;
import br.com.bb.intranet.supermt.model.Noticia;
import br.com.bb.intranet.supermt.model.Usuario;
import br.com.bb.intranet.supermt.repository.Noticias;
import br.com.bb.intranet.supermt.repository.Usuarios;
import br.com.bb.intranet.supermt.service.CadastroNoticias;
import br.com.bb.intranet.supermt.service.NoticiaException;

@Named
@javax.faces.view.ViewScoped
public class CadastroNoticiaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private CadastroNoticias cadastro;

	@Inject
	private Usuarios usuarios;

	@Inject
	private Noticias noticias;

	private Noticia noticia;

	public void prepararCadastro() {
		if (this.noticia == null) {
			this.noticia = new Noticia();
		}
	}

	public List<String> pesquisarTitulos(String titulo) {
		return this.noticias.descricoesQueContem(titulo);
	}

	public void salvar() {
		FacesContext context = FacesContext.getCurrentInstance();

		try {
			this.noticia.setUsuarioCadastro(this.apenasParaTesteLocal());
			this.cadastro.salvar(this.noticia);
			this.noticia = new Noticia();
			context.addMessage(null, new FacesMessage("Noticia inserida com sucesso!"));
		} catch (NoticiaException ne) {

			FacesMessage mensagem = new FacesMessage(ne.getMessage());
			mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
			context.addMessage(null, mensagem);
		}

	}

	public Noticia getNoticia() {
		return noticia;
	}

	public void setNoticia(Noticia noticia) {
		this.noticia = noticia;
	}
	
	public EstadoNoticia[] getEstadosNoticias() {
		return EstadoNoticia.values();
	}

	private Usuario apenasParaTesteLocal() {
		return this.usuarios.porId((long) 1);
	}
}
