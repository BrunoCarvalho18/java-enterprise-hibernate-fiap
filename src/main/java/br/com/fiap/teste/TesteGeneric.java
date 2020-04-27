package br.com.fiap.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import br.com.fiap.dao.ClienteDAO;
import br.com.fiap.entity.Cliente;

public class TesteGeneric {
	
	public static void main(String[] args) {
		EntityManager em = Persistence.createEntityManagerFactory("smartcities-orm").createEntityManager();
		
		ClienteDAO clienteDAO = new ClienteDAO(em);
		
		Cliente entidade = new Cliente(0,"Poyatos", null);
		clienteDAO.cadastrar(entidade);
		
		try {
			clienteDAO.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		List<Cliente> lista = clienteDAO.listar();
	    for(Cliente cliente:lista) {
	    	System.out.println(cliente.getId() + " " + cliente.getNome());
	    }
	}

}
