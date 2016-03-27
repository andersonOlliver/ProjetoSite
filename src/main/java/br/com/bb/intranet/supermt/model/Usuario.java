package br.com.bb.intranet.supermt.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "usuario") 
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long idUsuario;
//	private String nomeCompleto;
	private String nome;
//	private String chave;
//	private String prefixo;
//	private String rf;
//    private String nivelCodigo;
//    private String codigoComissao;
    
    @Id
	@GeneratedValue
	public Long getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}
	

	@NotEmpty
	@Size(max = 100)
	@Column(length = 100, nullable = false)
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idUsuario == null) ? 0 : idUsuario.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (idUsuario == null) {
			if (other.idUsuario != null)
				return false;
		} else if (!idUsuario.equals(other.idUsuario))
			return false;
		return true;
	}
//	@NotEmpty
//	@Size(max = 200)
//	@Column(length = 200, nullable = false)
//	public String getNomeCompleto() {
//		return nomeCompleto;
//	}
//	public void setNomeCompleto(String nomeCompleto) {
//		this.nomeCompleto = nomeCompleto;
//	}
//		
//	@NotNull
//	@Size(max = 10, min = 7)
//	@Column(length = 10)
//	public String getChave() {
//		return chave;
//	}
//	public void setChave(String chave) {
//		this.chave = chave;
//	}
//	
//	@NotNull
//	@Column(length = 5)
//	public String getPrefixo() {
//		return prefixo;
//	}
//	public void setPrefixo(String prefixo) {
//		this.prefixo = prefixo;
//	}
//	
//	@Size(max = 10)
//	@Column(length = 10)
//	public String getRf() {
//		return rf;
//	}
//	public void setRf(String rf) {
//		this.rf = rf;
//	}
//	
//	@Size(max = 10)
//	@Column(length = 10)
//	public String getNivelCodigo() {
//		return nivelCodigo;
//	}
//	public void setNivelCodigo(String nivelCodigo) {
//		this.nivelCodigo = nivelCodigo;
//	}
//	
//	@Size(max = 10)
//	@Column(length = 10)
//	public String getCodigoComissao() {
//		return codigoComissao;
//	}
//	public void setCodigoComissao(String codigoComissao) {
//		this.codigoComissao = codigoComissao;
//	}
//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((idUsuario == null) ? 0 : idUsuario.hashCode());
//		return result;
//	}
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Usuario other = (Usuario) obj;
//		if (idUsuario == null) {
//			if (other.idUsuario != null)
//				return false;
//		} else if (!idUsuario.equals(other.idUsuario))
//			return false;
//		return true;
//	}
//	@Override
//	public String toString() {
//		return "Usuario [idUsuario=" + idUsuario + ", nomeCompleto=" + nomeCompleto + ", nome=" + nome + ", chave="
//				+ chave + ", prefixo=" + prefixo + ", rf=" + rf + ", nivelCodigo=" + nivelCodigo + ", codigoComissao="
//				+ codigoComissao + "]";
//	}
//
	
    
	
    
    
}
