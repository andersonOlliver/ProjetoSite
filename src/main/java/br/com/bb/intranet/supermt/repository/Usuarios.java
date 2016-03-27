package br.com.bb.intranet.supermt.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.bb.intranet.supermt.model.Usuario;

public class Usuarios implements Serializable {

    private static final long serialVersionUID = 1L;

    private EntityManager manager;

    @Inject
    public Usuarios(EntityManager manager) {
        this.manager = manager;
    }

//    INSERÇÕES 
    public Usuario guardar(Usuario usuario) {
        return this.manager.merge(usuario);
    }
    
    public void adicionar(Usuario usuario){
        this.manager.persist(usuario);
    }
    
//    REMOÇÃO
    public void remover(Usuario usuario){
        this.manager.remove(usuario);
    }

//    CONSULTAS
    
    public Usuario porId(Long id) {
        return manager.find(Usuario.class, id);
    }

//    public Usuario porChave(String chave){
//    	return manager.find(Usuario.class, chave);
//    }
    
    public List<Usuario> todos() {
        TypedQuery<Usuario> query = manager.createQuery(
        		"from Usuario", Usuario.class);
        return query.getResultList();
    }
}
