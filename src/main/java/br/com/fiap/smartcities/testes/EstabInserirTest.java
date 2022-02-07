package br.com.fiap.smartcities.testes;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import br.com.fiap.smartcities.domain.Estabelecimento;
import br.com.fiap.smartcities.domain.TipoEstabelecimento;

public class EstabInserirTest {

	public static void main(String[] args) {
		
		EntityManager em = null;

		try { 
			
			em = Persistence.createEntityManagerFactory("smartcities-orm").createEntityManager();
			em.getTransaction().begin();
			
			TipoEstabelecimento tipo = new TipoEstabelecimento(1,null);
			
			Estabelecimento estab1 = new Estabelecimento();
			estab1.setNome("Loja 1");
			estab1.setTipo(tipo);
			em.persist(estab1);
			
			Estabelecimento estab2 = new Estabelecimento();
			estab2.setNome("Loja 2");
			estab2.setTipo(tipo);
			em.persist(estab2);
			
			
			em.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			if (em != null && em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
		} finally {
			if (em != null) {
				em.close();
			}
		}
		
	}

}
