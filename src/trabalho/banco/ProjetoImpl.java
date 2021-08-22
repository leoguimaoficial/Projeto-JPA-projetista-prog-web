package trabalho.banco;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import trabalho.entidades.Pessoa;
import trabalho.entidades.Projeto;

public class ProjetoImpl implements Banco<Projeto>{
	public void insert(Projeto projeto) {
		EntityManager entityManager = JPAUtil.getEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(projeto);
		entityManager.getTransaction().commit();
	}

	public void remove(Projeto projeto) {
		EntityManager entityManager = JPAUtil.getEntityManager();
		entityManager.getTransaction().begin();
		entityManager.remove(projeto);
		entityManager.getTransaction().commit();

	}

	public void update(Projeto projeto) {
		EntityManager entityManager = JPAUtil.getEntityManager();
		entityManager.getTransaction().begin();
		entityManager.merge(projeto);
		entityManager.getTransaction().commit();

	}

	public List<Projeto> findAll() {
		EntityManager entityManager = JPAUtil.getEntityManager();
		return entityManager.createQuery("SELECT t FROM Projeto t", Projeto.class).getResultList();
	}

	public Projeto findById(long id) {
		EntityManager entityManager = JPAUtil.getEntityManager();
		return entityManager.getReference(Projeto.class, id);
	}

	public Map<Pessoa,List<Projeto>> findByProjetoFromPessoaAll(){
		EntityManager entityManager = JPAUtil.getEntityManager();
		List<Pessoa> projetoList = new PessoaImpl().findAll();
		Map<Pessoa, List<Projeto>> pessoaProjetoMap = new HashMap<Pessoa, List<Projeto>>();
		for (Pessoa pessoa: pessoaList) {
			Query query = entityManager.createQuery("SELECT t FROM Projeto T WHERE Projeto .pessoa=:pessoa");
			query.setParameter("pessoa", pessoa);
			pessoaProjetoMap.put(pessoa, query.getResultList());
		}
		return pessoaProjetoMap;
	}

}
