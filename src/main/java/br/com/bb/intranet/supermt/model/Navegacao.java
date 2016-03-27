package br.com.bb.intranet.supermt.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "navegacao")
public class Navegacao implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private Long idnavegacao;
	private Usuario usuario;
	private String pagina;
	private Date data;

	@Id
	@GeneratedValue
	public Long getIdnavegacao() {
		return this.idnavegacao;
	}

	public void setIdnavegacao(Long idnavegacao) {
		this.idnavegacao = idnavegacao;
	}

	@NotNull
	@ManyToOne(optional = false)
	@JoinColumn(name = "usuario_id")
	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@NotNull
	@Size(max = 500)
	@Column(length = 500)
	public String getPagina() {
		return this.pagina;
	}

	public void setPagina(String pagina) {
		this.pagina = pagina;
	}

	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data")
	public Date getData() {
		return this.data;
	}

	public void setData(Date data) {
		this.data = data;
	}

}
