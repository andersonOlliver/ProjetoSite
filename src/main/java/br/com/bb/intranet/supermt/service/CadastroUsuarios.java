/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bb.intranet.supermt.service;

import br.com.bb.intranet.supermt.model.Usuario;
import br.com.bb.intranet.supermt.repository.Usuarios;
import br.com.bb.intranet.supermt.util.Transactional;
import java.io.Serializable;
import javax.inject.Inject;


public class CadastroUsuarios implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Inject
    private Usuarios usuarios;
    
    @Transactional
    public void salvar(Usuario usuario) throws UsuariosException{
        if(usuario == null){
            throw new UsuariosException("Usuário não pode ser nulo!");
        }
        this.usuarios.guardar(usuario);
    }
    
    @Transactional
    public void excluir(Usuario usuario) throws UsuariosException{
        usuario = this.usuarios.porId(usuario.getIdUsuario());
        
        this.usuarios.remover(usuario);
    }
}
