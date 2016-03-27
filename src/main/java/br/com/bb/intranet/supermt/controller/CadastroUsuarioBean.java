/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bb.intranet.supermt.controller;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.bb.intranet.supermt.model.Usuario;
import br.com.bb.intranet.supermt.service.CadastroUsuarios;
import br.com.bb.intranet.supermt.service.UsuariosException;

/**
 *
 * @author ander
 */
@Named
@ViewScoped
public class CadastroUsuarioBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private CadastroUsuarios cadastro;

    private Usuario usuario = new Usuario();

    public void salvar() {
        FacesContext context = FacesContext.getCurrentInstance();

        try {
            this.cadastro.salvar(this.usuario);
            this.usuario = new Usuario();
            context.addMessage(null, new FacesMessage("Usuario adicionado com sucesso!"));
        } catch (UsuariosException ue) {
            FacesMessage mensagem = new FacesMessage(ue.getMessage());
            mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
            context.addMessage(null, mensagem);
        }
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}
