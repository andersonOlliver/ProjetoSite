package br.com.bb.intranet.supermt.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import br.com.bb.intranet.supermt.model.Navegacao;

public class Navegacoes implements Serializable {

	private static final long serialVersionUID = 1L;

	private EntityManager manager;

	@Inject
	public Navegacoes(EntityManager manager) {
		this.manager = manager;
	}

	public void adicionar(Navegacao navegacao) {
		this.manager.persist(navegacao);
	}

	public Navegacao porId(Long id) {
		return manager.find(Navegacao.class, id);
	}
	
//	public List<Navegacao> todos(){
//		Criteria criteria = criarCriteriaParaFiltro(new FiltroNavegacao())
//	}
	
	@SuppressWarnings("unchecked")
	public List<Navegacao> filtrados(FiltroNavegacao filtro){
		Criteria criteria = criarCriteriaParaFiltro(filtro);
		
		criteria.setFirstResult(filtro.getPrimeiroRegistro());
		criteria.setMaxResults(filtro.getQuantidadeRegistros());
		
		if(filtro.isAscendente() && filtro.getPropriedadeOrdenacao() != null){
			criteria.addOrder(Order.asc(filtro.getPropriedadeOrdenacao()));
		}else if(filtro.getPropriedadeOrdenacao() != null){
			criteria.addOrder(Order.desc(filtro.getPropriedadeOrdenacao()));
		}
		
		return criteria.list();
	}

	public int quantidadeAcessosGerais(FiltroNavegacao filtro){
		Criteria criteria = criarCriteriaParaFiltro(filtro);
		
		criteria.setProjection(Projections.rowCount());
		
		return ((Number) criteria.uniqueResult()).intValue();
	}
	
	private Criteria criarCriteriaParaFiltro(FiltroNavegacao filtro) {
		Session session = manager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(Navegacao.class, "navegacao");

		if (StringUtils.isNotEmpty(filtro.getChaveUsuario())) {
			criteria.createAlias("navegacao.usuario", "user");
			criteria.add(Restrictions.ilike("user.chave", filtro.getChaveUsuario()));
		}

		return criteria;
	}
}
