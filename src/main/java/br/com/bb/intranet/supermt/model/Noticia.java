package br.com.bb.intranet.supermt.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "noticia")
public class Noticia implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long idNoticia;
	private Usuario usuarioCadastro;
	private String titulo;
	private String conteudo;
	private String caminhoImagemMenor;
	private String caminhoImagemMaior;
	private Date dataPostagem;
	private Date dataRetirada;
	private EstadoNoticia estadoAtual;

	@Id
	@GeneratedValue
	public Long getIdNoticia() {
		return idNoticia;
	}

	public void setIdNoticia(Long idNoticia) {
		this.idNoticia = idNoticia;
	}

	@NotNull
	@ManyToOne(optional = false)
	@JoinColumn(name = "usuario_id")
	public Usuario getUsuarioCadastro() {
		return usuarioCadastro;
	}

	public void setUsuarioCadastro(Usuario usuarioCadastro) {
		this.usuarioCadastro = usuarioCadastro;
	}

	@NotEmpty
	@Size(max = 200)
	@Column(length = 200, nullable = false)
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	@NotNull
	@Size(max = 5000)
	@Column(length = 5000, nullable = false)
	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	@Column(length = 500)
	public String getCaminhoImagemMenor() {
		return caminhoImagemMenor;
	}

	public void setCaminhoImagemMenor(String caminhoImagemMenor) {
		this.caminhoImagemMenor = caminhoImagemMenor;
	}

	@Column(length = 500)
	public String getCaminhoImagemMaior() {
		return caminhoImagemMaior;
	}

	public void setCaminhoImagemMaior(String caminhoImagemMaior) {
		this.caminhoImagemMaior = caminhoImagemMaior;
	}

	@NotNull
	@Temporal(TemporalType.DATE)
	@Column(name = "data_postagem", nullable = false)
	public Date getDataPostagem() {
		return dataPostagem;
	}

	public void setDataPostagem(Date dataPostagem) {
		this.dataPostagem = dataPostagem;
	}

	@NotNull
	@Temporal(TemporalType.DATE)
	@Column(name = "data_retirada", nullable = false)
	public Date getDataRetirada() {
		return dataRetirada;
	}

	public void setDataRetirada(Date dataRetirada) {
		this.dataRetirada = dataRetirada;
	}

	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	public EstadoNoticia getEstadoAtual() {
		return estadoAtual;
	}

	public void setEstadoAtual(EstadoNoticia estadoAtual) {
		this.estadoAtual = estadoAtual;
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idNoticia == null) ? 0 : idNoticia.hashCode());
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
		Noticia other = (Noticia) obj;
		if (idNoticia == null) {
			if (other.idNoticia != null)
				return false;
		} else if (!idNoticia.equals(other.idNoticia))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Noticia [idNoticia=" + idNoticia + ", titulo=" + titulo + ", conteudo=" + conteudo
				+ ", caminhoImagemMenor=" + caminhoImagemMenor + ", caminhoImagemMaior=" + caminhoImagemMaior
				+ ", dataPostagem=" + dataPostagem + ", dataRetirada=" + dataRetirada + ", estadoAtual=" + estadoAtual
				+ "]";
	}

}
