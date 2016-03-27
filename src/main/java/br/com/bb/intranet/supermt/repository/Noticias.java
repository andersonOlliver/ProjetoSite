package br.com.bb.intranet.supermt.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.bb.intranet.supermt.model.Noticia;

public class Noticias implements Serializable {

	private static final long serialVersionUID = 1L;

	private EntityManager manager;

	@Inject
	public Noticias(EntityManager manager) {
		this.manager = manager;
	}

	public Noticia porId(Long id) {
		return manager.find(Noticia.class, id);
	}

	public List<String> descricoesQueContem(String titulo) {
		TypedQuery<String> query = manager.createQuery(
				"select distinct titulo from Noticia " 
				+ "where upper(titulo) like upper(:titulo)",
				String.class);
		query.setParameter("titulo", "%" + titulo + "%");
		return query.getResultList();
	}
	
	public List<Noticia> todos() {
		TypedQuery<Noticia> query = manager.createQuery(
				"from Noticia", Noticia.class);
		return query.getResultList();
	}

	public void adicionar(Noticia noticia) {
		this.manager.persist(noticia);
	}

	public Noticia guardar(Noticia noticia) {
		return this.manager.merge(noticia);
	}

	public void remover(Noticia noticia) {
		this.manager.remove(noticia);
	}
}
