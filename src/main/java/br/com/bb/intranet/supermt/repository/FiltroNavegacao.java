package br.com.bb.intranet.supermt.repository;

import java.io.Serializable;
import java.util.Date;

public class FiltroNavegacao implements Serializable {

	private static final long serialVersionUID = 1L;

	private String pagina;
	private String chaveUsuario;
	private Date dataComeco;
	private Date dataFim;
	
	private int primeiroRegistro;
	private int quantidadeRegistros;
	private String propriedadeOrdenacao;
	private boolean ascendente;
	public String getPagina() {
		return pagina;
	}
	public void setPagina(String pagina) {
		this.pagina = pagina;
	}
	public String getChaveUsuario() {
		return chaveUsuario;
	}
	public void setChaveUsuario(String chaveUsuario) {
		this.chaveUsuario = chaveUsuario;
	}
	public Date getDataComeco() {
		return dataComeco;
	}
	public void setDataComeco(Date dataComeco) {
		this.dataComeco = dataComeco;
	}
	public Date getDataFim() {
		return dataFim;
	}
	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}
	public int getPrimeiroRegistro() {
		return primeiroRegistro;
	}
	public void setPrimeiroRegistro(int primeiroRegistro) {
		this.primeiroRegistro = primeiroRegistro;
	}
	public int getQuantidadeRegistros() {
		return quantidadeRegistros;
	}
	public void setQuantidadeRegistros(int quantidadeRegistros) {
		this.quantidadeRegistros = quantidadeRegistros;
	}
	public String getPropriedadeOrdenacao() {
		return propriedadeOrdenacao;
	}
	public void setPropriedadeOrdenacao(String propriedadeOrdenacao) {
		this.propriedadeOrdenacao = propriedadeOrdenacao;
	}
	public boolean isAscendente() {
		return ascendente;
	}
	public void setAscendente(boolean ascendente) {
		this.ascendente = ascendente;
	}
	
	
	
}
