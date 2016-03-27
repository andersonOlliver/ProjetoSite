package br.com.bb.intranet.supermt.controller;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import br.com.bb.intranet.supermt.model.Navegacao;
import br.com.bb.intranet.supermt.repository.FiltroNavegacao;
import br.com.bb.intranet.supermt.repository.Navegacoes;

@Named
@ViewScoped
public class ConsultaNavegacaoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Navegacoes navegacaoRepositorio;
	
	private FiltroNavegacao filtro = new FiltroNavegacao();
	private LazyDataModel<Navegacao> model;
	
	public ConsultaNavegacaoBean(){
		model = new LazyDataModel<Navegacao>() {
			
			private static final long serialVersionUID = 1L;
			
			@Override
			public List<Navegacao> load(int first, int pageSize,
					String sortField, SortOrder sortOrder,
					Map<String, Object> filters){
				filtro.setPrimeiroRegistro(first);
				filtro.setQuantidadeRegistros(pageSize);
				filtro.setAscendente(SortOrder.ASCENDING.equals(sortOrder));
				filtro.setPropriedadeOrdenacao(sortField);
				
				setRowCount(navegacaoRepositorio.quantidadeAcessosGerais(filtro));

				return navegacaoRepositorio.filtrados(filtro);
			}
		};
	}

	public FiltroNavegacao getFiltro() {
		return filtro;
	}

	public LazyDataModel<Navegacao> getModel() {
		return model;
	}
	
	
}
