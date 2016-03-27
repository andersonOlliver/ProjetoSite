/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bb.intranet.supermt.controller;

import br.com.bb.intranet.supermt.model.Usuario;
import br.com.bb.intranet.supermt.repository.Usuarios;
import br.com.bb.intranet.supermt.service.CadastroUsuarios;
import br.com.bb.intranet.supermt.service.UsuariosException;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author ander
 */
@Named
@ViewScoped
public class ConsultaUsuariosBean implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Inject
    private Usuarios usuariosRepositorio;
    
    @Inject
    private CadastroUsuarios cadastro;

    private List<Usuario> usuarios;
    private Usuario usuarioSelecionado;
    
    public void consultar(){
        this.usuarios = usuariosRepositorio.todos();
    }
    
    public void excluir(){
        FacesContext context = FacesContext.getCurrentInstance();
        
        try{
            this.cadastro.excluir(this.usuarioSelecionado);
            this.consultar();
            
            context.addMessage(null, new FacesMessage("Usuario Removido!"));
        } catch(UsuariosException ue){
            FacesMessage mensagem = new FacesMessage(ue.getMessage());
			mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
			context.addMessage(null, mensagem);
        }
    }

    public Usuario getUsuarioSelecionado() {
        return usuarioSelecionado;
    }

    public void setUsuarioSelecionado(Usuario usuarioSelecionado) {
        this.usuarioSelecionado = usuarioSelecionado;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }
    
    
}


