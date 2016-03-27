package br.com.bb.intranet.supermt.model;

public enum EstadoNoticia {

	FUTURA_EXIBICAO("Futura exibição"),
	ATIVO("Ativo"),
	EXPIRADO("Expirado");
	
	private String estado;
	
	private EstadoNoticia(String estado) {
		this.estado = estado;
	}
	
	public String getEstado(){
		return this.estado;
	}
}
