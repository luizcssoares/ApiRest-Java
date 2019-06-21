package br.luiz.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import br.luiz.entity.Usuario;
 
@Path("/servico")
public class CrudrestService implements IfacerestService{
	
	//@PersistenceUnit(unitName = "UsuarioPU")
    //private EntityManagerFactory EF;
	//private EntityManager EM = EF.createEntityManager();
		
	@PersistenceContext(unitName = "UsuarioPU")
	private EntityManager EM;
 			
	@GET
	@Produces("text/plain; charset=UTF-8")
	@Path("teste")
	public String teste(){ 									
			return "teste";
	}
		
	@GET
	@Produces("application/json; charset=UTF-8")
	@Path("usuarios")
	public List<Usuario> todosUsuarios(){ 	
			TypedQuery<Usuario> consulta = EM.createQuery("SELECT usu FROM Usuario usu", Usuario.class);						
			return consulta.getResultList();
	}
 
	@GET
	@Produces("application/json; charset=UTF-8")
	@Path("/usuario/{id}")
	public Usuario GetUsuario(@PathParam("id") Integer id){ 
		Usuario usu = EM.find(Usuario.class, id);
		return usu;	    
	}
 
	@DELETE
	@Produces("application/json; charset=UTF-8")
	@Path("/excluir/{id}")	
	public String Excluir(@PathParam("id") Integer id){		
		Usuario usu = EM.find(Usuario.class, id);
		EM.remove(usu);	
		return "Registro excluido com sucesso!"; 
	}
 
}